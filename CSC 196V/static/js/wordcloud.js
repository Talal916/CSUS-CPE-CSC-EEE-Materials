var text_string =
   "Of course that’s your contention. You’re a first year grad student. You just got finished readin’ some Marxian historian, Pete Garrison probably. You’re gonna be convinced of that ’til next month when you get to James Lemon and then you’re gonna be talkin’ about how the economies of Virginia and Pennsylvania were entrepreneurial and capitalist way back in 1740. That’s gonna last until next year. You’re gonna be in here regurgitating Gordon Wood, talkin’ about, you know, the Pre-Revolutionary utopia and the capital-forming effects of military mobilization… ‘Wood drastically underestimates the impact of social distinctions predicated upon wealth, especially inherited wealth.’ You got that from Vickers, Work in Essex County, page 98, right? Yeah, I read that, too. Were you gonna plagiarize the whole thing for us? Do you have any thoughts of your own on this matter? Or do you, is that your thing? You come into a bar. You read some obscure passage and then pretend, you pawn it off as your own, as your own idea just to impress some girls and embarrass my friend? See, the sad thing about a guy like you is in 50 years, you’re gonna start doin’ some thinkin’ on your own and you’re gonna come up with the fact that there are two certainties in life. One: don’t do that. And two: you dropped a hundred and fifty grand on a fuckin’ education you coulda got for a dollar fifty in late charges at the public library.";

drawWordCloud(text_string);

function drawWordCloud(text_string) {
   var common =
      "poop,i,me,my,myself,we,us,our,ours,ourselves,you,your,yours,yourself,yourselves,he,him,his,himself,she,her,hers,herself,it,its,itself,they,them,their,theirs,themselves,what,which,who,whom,whose,this,that,these,those,am,is,are,was,were,be,been,being,have,has,had,having,do,does,did,doing,will,would,should,can,could,ought,i'm,you're,he's,she's,it's,we're,they're,i've,you've,we've,they've,i'd,you'd,he'd,she'd,we'd,they'd,i'll,you'll,he'll,she'll,we'll,they'll,isn't,aren't,wasn't,weren't,hasn't,haven't,hadn't,doesn't,don't,didn't,won't,wouldn't,shan't,shouldn't,can't,cannot,couldn't,mustn't,let's,that's,who's,what's,here's,there's,when's,where's,why's,how's,a,an,the,and,but,if,or,because,as,until,while,of,at,by,for,with,about,against,between,into,through,during,before,after,above,below,to,from,up,upon,down,in,out,on,off,over,under,again,further,then,once,here,there,when,where,why,how,all,any,both,each,few,more,most,other,some,such,no,nor,not,only,own,same,so,than,too,very,say,says,said,shall";

   var word_count = {};

   var words = text_string.split(/[ '\-\(\)\*":;\[\]|{},.!?]+/);
   if (words.length == 1) {
      word_count[words[0]] = 1;
   } else {
      words.forEach(function(word) {
         var word = word.toLowerCase();
         if (word != "" && common.indexOf(word) == -1 && word.length > 1) {
            if (word_count[word]) {
               word_count[word]++;
            } else {
               word_count[word] = 1;
            }
         }
      });
   }

   var svg_location = "#chart";
   var width = $(document).width();
   var height = $(document).height();

   var fill = d3.scale.category20();

   var word_entries = d3.entries(word_count);

   var xScale = d3.scale
      .linear()
      .domain([
         0,
         d3.max(word_entries, function(d) {
            return d.value;
         })
      ])
      .range([10, 100]);

   d3.layout
      .cloud()
      .size([width, height])
      .timeInterval(20)
      .words(word_entries)
      .fontSize(function(d) {
         return xScale(+d.value);
      })
      .text(function(d) {
         return d.key;
      })
      .rotate(function() {
         return ~~(Math.random() * 2) * 90;
      })
      .font("Impact")
      .on("end", draw)
      .start();

   function draw(words) {
      d3.select(svg_location)
         .append("svg")
         .attr("width", width)
         .attr("height", height)
         .append("g")
         .attr("transform", "translate(" + [width >> 1, height >> 1] + ")")
         .selectAll("text")
         .data(words)
         .enter()
         .append("text")
         .style("font-size", function(d) {
            return xScale(d.value) + "px";
         })
         .style("font-family", "Impact")
         .style("fill", function(d, i) {
            return fill(i);
         })
         .attr("text-anchor", "middle")
         .attr("transform", function(d) {
            return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
         })
         .text(function(d) {
            return d.key;
         });
   }

   d3.layout.cloud().stop();
}
