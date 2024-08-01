document.addEventListener('DOMContentLoaded',() => {

const apiUrl = 'http://127.0.0.1:8080/api/account/1234';

const checkbox = document.getElementById('enable-toggle');
const dropdown = document.getElementById('percentage-select');
const dropdown2 = document.getElementById('percentage-select2');
const goalamount = document.getElementById('goalamount');
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
      checkbox.checked = `${data.smallsavings}`;
      dropdown.value = `${data.smallsavingsperc1}` ;
      dropdown2.value = `${data.smallsavingsperc2}` ;
      goalamount.value = `${data.targetgoal}` ;
    }
   
  })
  .catch(error => {
    console.error('Error:', error);
  });
});
function submitForm(){

  const apiSaveUrl = 'http://127.0.0.1:8080/api/smallsavingaccount/1234';
  const checkbox = document.getElementById('enable-toggle');
const dropdown = document.getElementById('percentage-select');
const dropdown2 = document.getElementById('percentage-select2');
const goalamount = document.getElementById('goalamount');
const data = {smallsavings : checkbox.checked,smallsavingsperc1 : dropdown.value,smallsavingsperc2 : dropdown2.value,targetgoal:goalamount.value};
fetch(apiSaveUrl,{
    method:'PUT',
    headers:{ 'Content-Type': 'application/json'},
body:JSON.stringify(data)
})
  .then(response => {
    alert("Your information saved successfully...");
    window.location.href = 'index.html';

    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => { 
    window.location.href = 'index.html';
   
  })
  .catch(error => {
    console.error('Error:', error);
  });
}