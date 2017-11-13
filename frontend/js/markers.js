var markers = [], markerDat, map;

function addMarkers(map) {
    this.map = map;
    clearMarkers();
    for (var i = 0; i < markerDat.length; i++) {
        addMarkerWithTimeout({lat: markerDat[i].x, lng: markerDat[i].y}, i * 100, markerDat[i].name);
    }
}
function addMarkerWithTimeout(position, timeout, info) {
    window.setTimeout(function() {
        markers.push(new google.maps.Marker({
            position: position,
            map: map,
            animation: google.maps.Animation.DROP,
            title: info
        }));
    }, timeout);
}
function clearMarkers() {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers = [];
}