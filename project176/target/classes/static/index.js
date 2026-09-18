const dataFromServer="Hello world";
const primaryHeaderElement=document.getElementById("primary-header");

primaryHeaderElement.textContent=dataFromServer;

function main(){
    console.log("Main function executed");
}
main();

const arrowFn = () =>  "hello";

console.log(arrowFn());