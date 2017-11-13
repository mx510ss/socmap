var tag = "EDUCATION", zoom = 14, radius = 20, dat;
$(document).ready(function () {
    setmap();
})

function setMenuTitle(obj) {
    $('#menutitle').text("Tag: " + obj.name.toUpperCase());
    tag = obj.name.toUpperCase();
}

function setmap() {
    var markermap1, markermap2, rectang;
    var myLatlng = new google.maps.LatLng(53.676, 23.819);
    var myOptions = {
        zoom: zoom,
        center: myLatlng,
        draggable: true,
        scrollwheel: false,
        clickableIcons: false,
        zoomControl: false
    };
    map = new google.maps.Map(document.getElementById("map"), myOptions);
    heatmap = new HeatmapOverlay(map, {
            "radius": radius,
            "maxOpacity": 2,
            blur: .85,
            "scaleRadius": false,
            "useLocalExtrema": false,
            latField: 'x',
            lngField: 'y',
            valueField: 'value'
        }
    );
    heatmap.setData({max:8, data:[{x: 0, y: 0, value: 8}]});
    google.maps.event.addListener(map,"rightclick", function (event) {
        if (markermap1 && markermap2) {
            if (rectang) {
                rectang.setMap(null);
                rectang = null;
            }
            if (markermap1) {
                markermap1.setMap(null);
                markermap1 = null;
            }
            if (markermap2) {
                markermap2.setMap(null);
                markermap2 = null;
            }
        }
        if (markermap1) {
            markermap2 = new google.maps.Marker({
                position: event.latLng,
                map: map,
                title: "1"
            });
            nor = Math.max(markermap2.position.lat(), markermap1.position.lat());
            sth = Math.min(markermap2.position.lat(), markermap1.position.lat());
            east = Math.max(markermap2.position.lng(), markermap1.position.lng());
            wst = Math.min(markermap2.position.lng(), markermap1.position.lng());
            centerlat = (nor + sth) / 2;
            centerlng = (east + wst) / 2;
            rectang = new google.maps.Rectangle({
                strokeColor: '#000000',
                strokeOpacity: 0.8,
                strokeWeight: 1,
                fillColor: '#0',
                fillOpacity: 0.05,
                map: map,
                bounds: {
                    north: nor,
                    south: sth,
                    east: east,
                    west: wst
                }
            });
            center = new google.maps.LatLng({lat: centerlat, lng: centerlng});

            getData(sth, wst, nor, east);
            map.panTo(center);
        }
        else{
            markermap1 = new google.maps.Marker({
                position: event.latLng,
                map: map,
                title: "2"
            });
        }
    });
    google.maps.event.addListener(map,"zoom_changed", function (ev) {
        var local_zoom = map.getZoom();
        console.info(local_zoom + " " + zoom);
        if(local_zoom > zoom){
            radius += 10;
            zoom = local_zoom;
        }
        if(local_zoom < zoom){
            radius -= 10;
            zoom = local_zoom;
        }
        console.info(zoom + " " + radius);
    });
}
function setInfo() {
    document.getElementById('inform').innerHTML = "Max value: "+dat.max + "\n Tag: " + tag +"\n";
}
function setHeatData(data) {

    mx = data.max;
    if(data.max == 0){
       mx = 8;
    }
    dat = {
        max: mx,
        data: data.data
    };
    console.info(dat.max + " " + data.max);
    heatmap.setData(dat);
    setInfo();
}
function getData(x1, y1, x2, y2) {
    jQuery.get('/api/heatmap', { x1: x1, y1: y1, x2: x2, y2: y2, type: tag}, function (data) {
        setHeatData(data);
    }, 'json');
}