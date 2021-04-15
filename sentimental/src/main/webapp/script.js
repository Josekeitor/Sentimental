function openTab(evt, tabName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
}

async function setUpVisualizer() {
  //tells the user how to start looking at the data
  await loadTweets();
  alert(
    "Welcome to the data visualizer! Click any of the tabs below to get started :)"
  );
}

function createTweet(tweet){
    var html = "<div class='tweet'><h4>"+tweet.sentimentScore+"</h4><p>"+tweet.text+"</p>"
    
    return html
}

function showTweets(city){
  const tweetsDiv = document.getElementById(city);
  console.log('city: ', city);
  console.log('tweet-div ', tweetsDiv);
  if (tweetsDiv.style.display === 'none') {
    tweetsDiv.style.display = 'flex';
  } else {
    tweetsDiv.style.display = 'none';
  }
  
}

async function loadTweets(){
  const response = await fetch('/fetch-tweets');
  const tweetsFromDS = await response.json();
    
  const result = document.getElementById('sentimentResult');
  var cities = [];
  totalTweets = tweetsFromDS.length;
  for(var i=0; i<50; i++){
      if(totalTweets < i){
          break;
      }
      tweetCity = tweetsFromDS[i].city;
      if(!cities.includes(tweetCity)){
        cities.push(tweetCity);
        
        result.innerHTML += "<div> <div class='city-header'><h2 class='city-name'>"+tweetCity+"</h2> <button onclick='showTweets("+"\""+tweetCity+"\""+")'> Expand </button></div><div class='tweet' id='" + tweetCity+"' style='display:none'>"+createTweet(tweetsFromDS[i])+"</div></div>";
      }else{
        const cityDiv = document.getElementById(tweetCity);
        cityDiv.innerHTML += createTweet(tweetsFromDS[i]);
      }
  }
  console.log("tweets: ", tweetsFromDS[0]);
}
function refreshData() {
    sentimentText();
}