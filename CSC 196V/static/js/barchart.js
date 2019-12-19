// Using d3-tip to add tooltips to a d3 bar chart.

var margin = { top: 40, right: 20, bottom: 120, left: 80 },
   width = 900,
   height = 460;

var x = d3.scale.ordinal().rangeRoundBands([0, width], 0.1);

var y = d3.scale.linear().range([height, 0]);

var xAxis = d3.svg
   .axis()
   .scale(x)
   .orient("bottom");

var yAxis = d3.svg
   .axis()
   .scale(y)
   .orient("left");

var tip = d3
   .tip()
   .attr("class", "d3-tip")
   .offset([-10, 0])
   .html(function(d) {
      return (
         "<strong>Releases:</strong> <span style='color:red'>" +
         d.Releases +
         "</span>"
      );
   });

//
// Change this line: var svg = d3.select("body").append("svg") to use the div you want.
// You can do var svg = d3.select("div").append("svg"), but this will append the SVG in
// the first div. You can select the div by class or ID, though. For instance, if the
// div has an ID of someDiv, do this: var svg = d3.select("#someDiv").append("svg")
//

// d3.select("body")
var svg = d3
   .select("#barchart")
   .append("svg")
   .attr("width", width + margin.left + margin.right)
   .attr("height", height + margin.top + margin.bottom)
   .append("g")
   .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

svg.call(tip);

d3.tsv("static/data/data.tsv", type, function(error, data) {
   x.domain(
      data.map(function(d) {
         return d.Genre;
      })
   );
   y.domain([
      0,
      d3.max(data, function(d) {
         return d.Releases;
      })
   ]);

   // x axis data labels
   svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis)
      .selectAll("text")
      .style("text-anchor", "end")
      .attr("font-size", "12px")
      .attr("dx", "-.8em")
      .attr("dy", ".15em")
      .attr("transform", "rotate(-65)")
      .attr("font-size", "13px");

   // y axis data labels
   svg.append("g")
      .attr("class", "y axis")
      .call(yAxis)
      .append("text")
      .attr("transform", "rotate(-90)")
      .attr("y", 0 - margin.left)
      .attr("dy", ".71em")
      .style("text-anchor", "end");

   // text label for the x axis
   svg.append("text")
      .attr(
         "transform",
         "translate(" + width / 2 + " ," + (height + margin.top + 60) + ")"
      )
      .style("text-anchor", "middle")
      .attr("font-size", "20px")
      .attr("x", 0 - height / 5)
      .attr("font-weight", "bold")
      .text("Genre");

   // text label for the y axis
   svg.append("text")
      .attr("transform", "rotate(-90)")
      .attr("y", 0 - margin.left)
      .attr("x", 0 - height / 2)
      .attr("dy", "1em")
      .style("text-anchor", "middle")
      .attr("font-size", "20px")
      .attr("font-weight", "bold")
      .text("Releases");

   svg.selectAll(".bar")
      .data(data)
      .enter()
      .append("rect")
      .attr("class", "bar")
      .attr("x", function(d) {
         return x(d.Genre);
      })

      .attr("fill", function(d) {
         if (d.Genre == "Drama") {
            return "#F000A4";
         } else if (d.Genre == "Comedy") {
            return "#F7FF00";
         } else if (d.Genre == "Thriller") {
            return "#FF0000";
         } else if (d.Genre == "Action") {
            return "#660000";
         } else if (d.Genre == "Romance") {
            return "#F300FF";
         } else if (d.Genre == "Horror") {
            return "#886AA6";
         } else if (d.Genre == "Adventure") {
            return "#007637";
         } else if (d.Genre == "Crime") {
            return "#854242";
         } else if (d.Genre == "Family") {
            return "#00E8FF";
         } else if (d.Genre == "Science Fiction") {
            return "#00FF49";
         } else if (d.Genre == "Fantasy") {
            return "#6C00FF";
         } else if (d.Genre == "Mystery") {
            return "#714B00";
         } else if (d.Genre == "Animation") {
            return "#FF8300";
         } else if (d.Genre == "Documentary") {
            return "#383838";
         } else if (d.Genre == "Music") {
            return "#3E9685";
         } else if (d.Genre == "History") {
            return "#E7CF00";
         } else if (d.Genre == "War") {
            return "#B00000";
         } else if (d.Genre == "Foreign") {
            return "#919D5C";
         } else if (d.Genre == "TV Movie") {
            return "#67BF9C";
         } else if (d.Genre == "Western") {
            return "#896A00";
         }
      })

      .attr("width", x.rangeBand())
      .attr("y", function(d) {
         return y(d.Releases);
      })
      .attr("height", function(d) {
         return height - y(d.Releases);
      })
      .on("mouseover", tip.show)
      .on("mouseout", tip.hide);
});

function type(d) {
   d.Releases = +d.Releases;
   return d;
}
