async function sentimentText() {
  //const text = document.getElementById('intro').innerHTML;
  
  //const params = new URLSearchParams();

  //params.append('message', text);
  
  const responseFromServer = await fetch('/sentiment', {method: "POST"});//, body: params});
}
 