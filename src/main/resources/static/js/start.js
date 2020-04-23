//example JSON
const userBudgetData = [ {
    id: 1,
    date: new Date(`02/01/2020`),
    budgetRemaining: 2000,
    gains: 300,
    losses: 1500
},
{ 
    id: 2,
    date: new Date(`03/01/2020`),
    budgetRemaining: -2000,
    gains: 4000,
    losses: 100
},
{
    id: 3,
    date: new Date(`04/01/2020`),
    budgetRemaining: -10000,
    gains: 345,
    losses: 0
},
{
    id: 4,
    date: new Date(`05/01/2020`),
    budgetRemaining: 10000,
    gains: 0,
    losses: 9000
},
{
    id: 5,
    date: new Date(`05/01/2021`),
    budgetRemaining: -10000,
    gains: 0,
    losses: 9000
},
{
    id: 6,
    date: new Date(`05/01/2019`),
    budgetRemaining: -10000,
    gains: 0,
    losses: 9000
}];


function createCards() {
    let success = false;

    //create button
    var addBudgetButton = document.createElement(`button`);
    addBudgetButton.type = "button";
    addBudgetButton.className = "btn btn-primary";
    addBudgetButton.innerHTML = `Add Monthly Budget`;

    document.body.appendChild(addBudgetButton);

    //sort by date descending
    let budgetData = userBudgetData.sort((a, b) => (b.date > a.date) ? 1 : ((a.date > b.date) ? -1 : 0));

    //create each card based on objects in array
    for (let month of budgetData) {
        var firstDiv = document.createElement(`div`);
        firstDiv.id = month.id;

        if(month.budgetRemaining > 0){
            firstDiv.className = "card text-white bg-success";
            success = true;
        }
        else{
            firstDiv.className = "card text-white bg-danger";
            success = false;
        }
        firstDiv.style.width = "30rem";

        var secondDiv = document.createElement(`div`);
        secondDiv.id = month.date + `2`;
        secondDiv.className = "card-header";

        var cardHeader = document.createElement(`h4`);
        cardHeader.innerHTML = month.date.toLocaleString('default', { month: 'long' }) + `, ` + month.date.getFullYear();

        var cardTitle = document.createElement(`h5`);
        cardTitle.className = "card-title";
        cardTitle.innerHTML = `Budget Remaining: ` + month.budgetRemaining;

        var cardText = document.createElement(`p`);
        if(success){
            cardText.className = "bg-success";
        }
        else {
            cardText.className = "bg-danger";
        }
        cardText.innerHTML = `Gains: ` + month.gains + `<br />Losses: ` + month.losses;
        
        document.body.appendChild(firstDiv);
        firstDiv.appendChild(secondDiv);
        secondDiv.appendChild(cardHeader);
        firstDiv.appendChild(cardTitle);
        firstDiv.appendChild(cardText);
    } 

};