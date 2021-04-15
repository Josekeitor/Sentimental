// Initialize and add the map
async function initMap() {
  const response = await fetch("/fetch-tweets", {method:'GET'});
  const datos = await response.json();
  /* Data points defined as a mixture of WeightedLocation and LatLng objects */
  let heatMapData = [];
  let mexicoCity = { lat: 19.432608, lng: -99.133209 };
  let guadalajara = { lat: 20.66682, lng: -103.39182 };
  let monterrey = { lat: 25.67507, lng: -100.31847 };
  for(let i = 0; i < datos.length; i++) {
      let index = datos[i].sentimentScore + 1;
      let loc;
      if(datos[i].city == "Ciudad de Mexico") {
          loc = new google.maps.LatLng(mexicoCity.lat - 1 + Math.random() * 2, mexicoCity.lng - 1 + Math.random() * 2);
      }
      if(datos[i].city == "Guadalajara") {
          loc = new google.maps.LatLng(guadalajara.lat - 1 + Math.random() * 2, guadalajara.lng - 1 + Math.random() * 2);
      }
      if(datos[i].city == "Monterrey") {
          loc = new google.maps.LatLng(monterrey.lat - 1 + Math.random() * 2, monterrey.lng - 1 + Math.random() * 2);
      }
      heatMapData.push({location: loc, weight: index});
  }
  // The map, centered at Mexico City
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 5,
    center: mexicoCity,
  });
  // The marker, positioned at Mexico City
  const marker = new google.maps.Marker({
    position: mexicoCity,
    map: map,
  });
  let heatmap = new google.maps.visualization.HeatmapLayer({
    data: heatMapData
  });
  heatmap.setMap(map);
  heatmap.set("radius", 20);
  const gradient = [
    "rgba(255,0,0, 0)",
    "rgba(255,0,0, 1)",
    "rgba(255,255,0, 1)",
    "rgba(0,255,0, 1)",
  ];
  heatmap.set("gradient", gradient);
}