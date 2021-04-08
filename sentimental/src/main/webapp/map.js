// Initialize and add the map
function initMap() {
  /* Data points defined as a mixture of WeightedLocation and LatLng objects */
  let heatMapData = [];
  let mexicoCity = { lat: 19.432608, lng: -99.133209 };
  for(let i = 0; i < 10; i++) {
      let loc = new google.maps.LatLng(mexicoCity.lat + Math.random(-5, 5), mexicoCity.lng + Math.random(-5, 5));
      heatMapData.push({location: loc, weight: (i / 10) + 1});
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
}