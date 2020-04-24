//example JSON
//const userBudgetData = [ {
//    id: 1,
//    date: new Date(`02/01/2020`),
//    budgetRemaining: 2000,
//    gains: 300,
//    losses: 1500
//},
//{ 
//    id: 2,
//    date: new Date(`03/01/2020`),
//    budgetRemaining: -2000,
//    gains: 4000,
//    losses: 100
//},
//{
//    id: 3,
//    date: new Date(`04/01/2020`),
//    budgetRemaining: -10000,
//    gains: 345,
//    losses: 0
//},
//{
//    id: 4,
//    date: new Date(`05/01/2020`),
//    budgetRemaining: 10000,
//    gains: 0,
//    losses: 9000
//},
//{
//    id: 5,
//    date: new Date(`05/01/2021`),
//    budgetRemaining: -10000,
//    gains: 0,
//    losses: 9000
//},
//{
//    id: 6,
//    date: new Date(`05/01/2019`),
//    budgetRemaining: -10000,
//    gains: 0,
//    losses: 9000
//}];

function createCards() {
    let success = false;
    var cardForm = document.getElementById(`cardForm`);

    //sort by date descending
    let budgetData = window["budgetData"];
    console.log(budgetData);
    budgetData = budgetData.sort((a, b) => (b.period > a.period) ? 1 : ((a.period > b.period) ? -1 : 0));

    //create each card based on objects in array
    for (let month of budgetData) {
        var firstDiv = document.createElement(`div`);
        firstDiv.id = month.budgetId;

        if(month.balance > 0){
            firstDiv.className = "card text-white bg-success";
            success = true;
        }
        else{
            firstDiv.className = "card text-white bg-danger";
            success = false;
        }
        firstDiv.style.width = "30rem";
        

        var secondDiv = document.createElement(`div`);
        secondDiv.id = month.budgetId + `2`;
        secondDiv.className = "card-header";

        var cardHeader = document.createElement(`h4`);
        cardHeader.innerHTML = month.period.toLocaleString('default', { month: 'long' }) + `, ` + month.period.getFullYear();
        
        var button = document.createElement(`button`);
        button.className = "btn btn-dark";
        button.type = "submit";
        button.innerHTML = "View Transactions";

        var cardTitle = document.createElement(`h5`);
        cardTitle.className = "card-title";
        cardTitle.innerHTML = `Budget Remaining: ` + month.balance;
        cardTitle.style.paddingLeft = "3em";

//        var cardText = document.createElement(`p`);
//        if(success){
//            cardText.className = "bg-success";
//        }
//        else {
//            cardText.className = "bg-danger";
//        }
//        cardText.innerHTML = `Gains: ` + month.gains + `<br />Losses: ` + month.losses;
//        cardText.style.paddingLeft = "4em";
        
        cardForm.appendChild(firstDiv);
        firstDiv.appendChild(secondDiv);
        secondDiv.appendChild(cardHeader);
        secondDiv.appendChild(button);
        firstDiv.appendChild(cardTitle);
//        firstDiv.appendChild(cardText);
    } 

};