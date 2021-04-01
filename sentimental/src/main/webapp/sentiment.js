async function sentimentText() {
  console.log("Entre");
  //const text = document.getElementById('intro').innerHTML;
  
  //const params = new URLSearchParams();

  //params.append('message', text);
  const responseFromServer = await fetch('/sentiment', {method: "POST"});//, body: params});
    
  const result = document.getElementById('sentimentResult');

  result.innerHTML = await responseFromServer.text();
  console.log(result);
}
 