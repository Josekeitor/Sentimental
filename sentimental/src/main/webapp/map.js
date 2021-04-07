// Initialize and add the map
function initMap() {
  // The location of Uluru
  const mexicoCity = { lat: 19.432608, lng: -99.133209 };
  // The map, centered at Uluru
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 5,
    center: mexicoCity,
  });
  // The marker, positioned at Uluru
  const marker = new google.maps.Marker({
    position: mexicoCity,
    map: map,
  });
}