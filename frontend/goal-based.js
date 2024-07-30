document.addEventListener('DOMContentLoaded',() => {

const apiUrl = 'http://127.0.0.1:8080/api/account/1234';


const smallsavingsAmtElement = document.getElementById('smallsavingsamt');
const smallsavingsAccElement = document.getElementById('smallsavingsacc');
const smallsavingsdetailsElement = document.getElementById('smallsavingsdetails');
const goalamountActivateElement = document.getElementById('goalamount');
fetch(apiUrl,{
    method:'GET',
    headers:{ 'Content-Type': 'application/json'},
mode:'cors' 
})
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    if(data.smallsavings === true)
    {
        smallsavingsAmtElement.innerHTML = `£${parseFloat(data.smallsavingsbalance.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","))}` ;
        smallsavingsAccElement.innerHTML = `${data.smallsavingsacc}` ;
        goalamountActivateElement.innerHTML = `£${data.targetgoal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}` ;
    }
    else
    {
        smallsavingsdetailsElement.innerHTML = `<p>Set up a <a href="./settings.html"><b>Goal-Based Savings</b></a> today and start saving</p>` ;
    }

  })
  .catch(error => {
    console.error('Error:', error);
  });
});
function settings()
{
    window.location.href = './settings.html';
}
function faqs()
{
    window.location.href = './faq.html';
}