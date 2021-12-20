/* 
    What is the DOM?
        Document Object Model
        - it is a object representation of your html page
        - We can us the DOM to manipulate HTML elements

*/


//any manipulation of html elements will go through the "document" object
console.log(document);


/* retrieving elements */
/* document.getElementById();
document.getElementsByClassName();
document.getElementsByTagName(); */

let gremlinsElem = document.getElementById("movie3");
console.log(gremlinsElem);
gremlinsElem.style.color = "red";
gremlinsElem.style.fontSize = "30px";


/* once we have retrieved an element and put it in a variable, we can manipulate the element with other properties 
    - innerText <--- change the text inside the element
    - innerHTML <--- modify the HTML within the element
    - addEventListener(event, cbf); <--- add functionality when an event happens
    - style <--- add styles to the element
    - appendChild <--- append element to another element

*/

//gremlinsElem.innerText = "Spiderman, Into the spiderverse";

gremlinsElem.innerHTML = "<h1>Spiderman, Into the spiderverse</h1>"
gremlinsElem.innerText = "Gremlins";

console.log(document.getElementsByClassName("movie"));
console.log(document.getElementsByTagName("div"));



/* deleting an element */
gremlinsElem.remove();



/* creating an element */

let btn = document.createElement("button");
btn.innerText = "Click Me!";

document.body.appendChild(btn);


/* lets add a movie to our movie container */
/* let movieElem = document.createElement("div");
movieElem.innerText = "The Grinch";
movieElem.className = "movie";
movieElem.id = `movie${document.getElementsByClassName("movie").length+1}`;

let movieContainer = document.getElementsByClassName("movie-container")[0];
movieContainer.appendChild(movieElem); */



/* 
    What is an event?
        - an action that happens to an HTML element

    common events:
        - click
        - submit
        - mouseover
        - load
        - etc

    What is an event listener?
        - an entity that actively listens for an event on an element
        - when that event is triggered, we provide functionality for that specific event


    Ways you can add an event listener
        - property on element
        - addEventListener(event, cbf);
        - attributes in html

*/

    let r = 0, b = 0, g = 0;
    const MAX_VAL = 255;
    btn.addEventListener("click", function(){
        r = Math.floor(Math.random() * MAX_VAL);
        b = Math.floor(Math.random() * MAX_VAL);
        g = Math.floor(Math.random() * MAX_VAL);


       btn.style.backgroundColor = `rgb(${r},${b},${g})`;

    });

/*     btn.onclick = function(){
        console.log("Test")
    } */

    let elfElem = document.getElementById("movie4");
    elfElem.addEventListener("mouseover", () => {
        const BIG_SIZE = "100px";
        const SMALL_SIZE = "50px";

        elfElem.style.fontSize = elfElem.style.fontSize == BIG_SIZE ? SMALL_SIZE : BIG_SIZE;
    });


    let movies = ["Alien", "Home Alone", "Get Out", "Demon Slayer Train Arc", "The Dark Knight"];



    populateMovieContainer(movies)

    function populateMovieContainer(movieList){
        //delete movie container completely
        document.getElementsByClassName("movie-container")[0].remove(); 

        //create new container
        let movieContainer = document.createElement("div");
        movieContainer.className = "movie-container";

        //create element for each item in the array
        movieList.forEach((element,i) => {
            let movieElem = document.createElement("div");
            movieElem.className = "movie";
            movieElem.id = `movie${i}`;
            movieElem.innerText = element;

            movieContainer.appendChild(movieElem)
        });
        
        //append to body
        document.body.appendChild(movieContainer);



    }



    function populateMovieContainer2(movieList){

        //get the movie element
        let movieContainer = document.getElementsByClassName("movie-container")[0];
        let childElements = movieContainer.children;

        console.log(childElements);

        //removes all child elements

        //programmitcally
        /* while(childElements.length != 0){
            childElements[0].remove();
        } */


        //bigbrain way
        //movieContainer.innerHTML = "";

        //smart way
        movieContainer.replaceChildren();



        //create movie elements and append to movie container
        movieList.forEach((element,i) => {
            let movieElem = document.createElement("div");
            movieElem.className = "movie";
            movieElem.id = `movie${i}`;
            movieElem.innerText = element;

            movieContainer.appendChild(movieElem)
        });

    }