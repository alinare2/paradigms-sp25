function solve(amount, bottles) {
    /* your solution goes here */
    //check of the amount is larger than the bottles using spread to find max
    if (amount > Math.max(...bottles)) return null;

    initialState = bottles.map(()=> 0);
    let queue = [ [[], initialState] ]
    let visited = new Set();
    let currPath = [];

    while (queue.length > 0){
        let currArray = queue.shift();
        let currState = currArray[1];
        let currPath = currArray[0].concat([currState]);
        
        if (currState.includes(amount) && currState.filter((x) => x != 0).length === 1){
            return currPath
        }

        if (!visited.has(currState.toString())){
            visited.add(currState.toString());
        };

        //operations
        for (let i = 0; i < bottles.length; i++){
            //fill bottles 
            let filled = currState.map((x)=> x);
            filled[i] = bottles[i];
            if (!visited.has(filled.toString())){
                visited.add(filled.toString());
                queue.push([currPath, filled])
            };

            //empty bottles 
            let emptied = currState.map((x) => x);
            emptied[i] = 0;
            if (!visited.has(emptied.toString())){
                visited.add(emptied.toString());
                queue.push([currPath, emptied]);
            };

            //transfer from bottle i to j
            for (let j = 0; j < bottles.length; j++) {
                //check if bottle is same bottle 
                if (i === j) continue;
                
                let poured = currState.map((x) => x);
                let pourAvailable = bottles[j] - currState[j];

                if (pourAvailable > currState[i]){
                    poured[j] = currState[j] + currState[i];
                    poured[i] = 0; 
                }
                else {
                    poured[j] = bottles[j];
                    poured[i] = currState[i] - pourAvailable;
                }
                
                if (!visited.has(poured.toString())) {
                    visited.add(poured.toString());
                    queue.push([currPath, poured]);
                }
            
            }
        }
        
    }

    return null;
}


//example 1
let bottles = [5,3];
let amount = 2;
console.log(solve(amount, bottles));

//example 2
bottles = [2,4];
amount = 1;
console.log(solve(amount, bottles));

//example 3
bottles = [10, 2, 1];
amount = 8;
console.log(solve(amount, bottles));

//example 4
bottles = [3,4, 2,1];
amount = 8;
console.log(solve(amount, bottles));

