document.addEventListener('DOMContentLoaded',() => {

const apiUrl = 'http://127.0.0.1:8080/api/account/1234';

const currentAmtElement = document.getElementById('currentamt');
const savingsAmtElement = document.getElementById('savingsamt');
const smallsavingsAmtElement = document.getElementById('smallsavingsamt');
const currentAccElement = document.getElementById('currentacc');
const savingsAccElement = document.getElementById('savingsacc');
const smallsavingsAccElement = document.getElementById('smallsavingsacc');
const smallsavingsdetailsElement = document.getElementById('smallsavingsdetails');
const smallsavingsActivateElement = document.getElementById('smallsavingsactivate');
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
    const curr = data.currentbalance ;
    const savings = data.savingsbalance ;
    currentAmtElement.innerHTML = `£${curr.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}` ;
    savingsAmtElement.innerHTML = `£${savings.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}` ;
    currentAccElement.innerHTML = `${data.currentacc}` ;
    savingsAccElement.innerHTML = `${data.savingsacc}` ;
    if(data.smallsavings === true || data.smallsavingsacc)
    {
        smallsavingsAmtElement.innerHTML = `£${parseFloat(data.smallsavingsbalance.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","))}` ;
        smallsavingsAccElement.innerHTML = `${data.smallsavingsacc}` ;
        goalamountActivateElement.innerHTML = `£${data.targetgoal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")}` ;
        if(data.smallsavings === false)
        {
          smallsavingsActivateElement.innerHTML = `<p>Activate back to enjoy your <a href="./settings.html"><b>Goal Savings</b></a></p>` ;
        }
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
function goalbased()
{
    window.location.href = './goal-based.html';
}