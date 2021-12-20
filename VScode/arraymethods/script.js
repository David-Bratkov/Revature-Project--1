window.onload = function(){

    let arr = [13, 29, 7, 2, 17, 89];
    console.log(arr);


    /* 
        arrays have alot of methods that can be utilized
        - these methods utilize the idea of callback functions.
        
        What is a callback function?
            - a function that is passed into another function as a parameter.
    */
    let sorted = arr.sort(function(a,b){
        if(a < b)
            return -1;
        else{
            return 1;
        }
    });

    console.log(sorted);


    /* let doubled = arr.map(function(element){
        return element * 2;
    }) */

    let doubled = arr.map(element => element * 2);


    console.log(doubled);

    /* let filtered = arr.filter(function(element){
        if(element > 50){
            return false;
        }

        return true;
    }) */

    let filtered = arr.filter(element => element < 50);


    console.log(filtered);


    let reversed = arr.reverse();
    console.log(reversed);


}


function doubleNum(x){
    return x * 2;
}