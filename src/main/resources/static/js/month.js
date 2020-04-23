//const userTransactionHistory = [
//    {
//        id: 1,
//        budget_id: 1,
//        date: new Date(`03/27/2020`),
//        note: `Basketball Pump`,
//        value: -25.00
//    },
//    {
//        id: 2,
//        budget_id: 1,
//        date: new Date(`03/22/2020`),
//        note: `Helped Brother Move`,
//        value: 100.00
//    },
//    {
//        id: 3,
//        budget_id: 1,
//        date: new Date(`03/20/2020`),
//        note: `Walter's Walnuts`,
//        value: -60.00
//    },
//    {
//        id: 4,
//        budget_id: 1,
//        date: new Date(`03/19/2020`),
//        note: `Joe's Shrimp Shack`,
//        value: -100.00
//    },
//    {
//        id: 5,
//        budget_id: 1,
//        date: new Date(`03/16/2020`),
//        note: `Investments`,
//        value: 1000.00
//    },
//    {
//        id: 6,
//        budget_id: 1,
//        date: new Date(`03/12/2020`),
//        note: `Coronavirus Test`,
//        value: -1040.00
//    },
//    {
//        id: 7,
//        budget_id: 1,
//        date: new Date(`03/11/2020`),
//        note: `ER Visit`,
//        value: -1100.00
//    },
//    {
//        id: 8,
//        budget_id: 1,
//        date: new Date(`03/10/2020`),
//        note: `Found Cash on Ground`,
//        value: 100.00
//    },
//    {
//        id: 9,
//        budget_id: 1,
//        date: new Date(`03/07/2020`),
//        note: `Tuition`,
//        value: -10000.00
//    },
//    {
//        id: 10,
//        budget_id: 1,
//        date: new Date(`03/04/2020`),
//        note: `Weekly Paycheck`,
//        value: 1000.00
//    },
//    {
//        id: 11,
//        budget_id: 1,
//        date: new Date(`03/02/2020`),
//        note: `Drinks at Bar`,
//        value: -50.00
//    }
//];
//
//const thisMonthsBudget = 
//{
//    id: 1,
//    date: new Date(),
//    budgetRemaining: 2000,
//    gains: 300,
//    losses: 1500
//};

function createCards() {
    let success = false;

    var titleDiv = document.createElement(`div`);
    titleDiv.className = `card bg-white`
    if(thisMonthsBudget.budgetRemaining > 0){
        titleDiv.style.color = `green`;
    }
    else{
        titleDiv.style.color = `red`;
    }
    titleDiv.style.width = "30rem";

    var budgetRemaining = document.createElement(`h3`);
    budgetRemaining.innerHTML = `Monthly Budget Remaining: ` + thisMonthsBudget.budgetRemaining;
    titleDiv.appendChild(budgetRemaining);

    var monthYear = document.createElement(`h3`);
    const options = { month: 'long', year: 'numeric' };
    monthYear.innerHTML = thisMonthsBudget.date.toLocaleString('default', options);
    titleDiv.appendChild(monthYear);

    //sort by date descending
    let transactionData = userTransactionHistory.sort((a, b) => (b.date > a.date) ? 1 : ((a.date > b.date) ? -1 : 0));

    //create each card based on objects in array
    for (let transaction of transactionData) {
        var firstDiv = document.createElement(`div`);
        firstDiv.id = transaction.id;

        if(transaction.value > 0){
            firstDiv.className = "card text-white bg-success";
            success = true;
        }
        else{
            firstDiv.className = "card text-white bg-danger";
            success = false;
        }
        firstDiv.style.width = "30rem";

        var cardTitle = document.createElement(`h5`);
        cardTitle.className = "card-title";
        const options = { weekday: 'long', month: 'long', day: 'numeric' };
        cardTitle.innerHTML = transaction.date.toLocaleString('default', options);

        var cardText = document.createElement(`p`);
        if(success){
            cardText.className = "bg-success";
        }
        else {
            cardText.className = "bg-danger";
        }

        let transactionString = transaction.value.toString();
        if(transactionString.includes(`-`)){
            transactionString = transactionString.slice(1, transactionString.length);
        }
        cardText.innerHTML = `$` + transactionString + `     –     ` + transaction.note;
        
        document.body.appendChild(titleDiv);
        titleDiv.appendChild(firstDiv);
        firstDiv.appendChild(cardTitle);
        firstDiv.appendChild(cardText);
    } 

};