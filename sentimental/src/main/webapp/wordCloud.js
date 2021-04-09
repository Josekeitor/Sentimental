anychart.onDocumentReady(async function(){

  var chart = anychart.tagCloud(data);
  
  const response = await fetch("/wordCloud", {method:'GET'});
  const datos = await response.json();
  var data = "";
  for(let i = 0; i < datos.length; i++){
        data += datos[i].text.toLowerCase() + " ";
  }

  chart.data(data, {
        mode: "byWord",
        maxItems: 15,
        ignoreItems: [
                      "y",
                      "el",
                      "la",
                      "lo",
                      "soy",
                      "no",
                      "si",
                      "porque",
                      "ese",
                      "que",
                      "me",
                      "como",
                      "cuando",
                      "donde",
                      "con",
                      "de",
                      "este",
                      "en",
                      "esta",
                      "estos",
                      "se",
                      "al"
                     ]
});
  

  chart.angles([0, -45, 90])

  chart.container("wordCloud");
  chart.draw();

    var customColorScale = anychart.scales.linearColor();
    customColorScale.colors(["#00CB0C", "#FF00A6", "#F001FB", "#B100BA", "AB00FF", "#323133"]);

    chart.colorScale(customColorScale);
    chart.colorRange().enabled(true);
});