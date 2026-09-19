const state = {
    users: [],
};

function renderUsers(){
    const usersTableElement = document.getElementById("users-list");
    const usersTableBodyElement = document.getElementById("users-list-body");

    for(const user of state.users){
        const trElement = document.createElement("tr");

        const idElement = document.createElement("td");
        idElement.textContent = user.id;
        trElement.appendChild(idElement);

        const firstNameElement = document.createElement("td");
        firstNameElement.textContent = user.firstName;
        trElement.appendChild(firstNameElement);

        const lastNameElement = document.createElement("td");
        lastNameElement.textContent = user.lastName;
        trElement.appendChild(lastNameElement);

        const emailElement = document.createElement("td");
        emailElement.textContent = user.email;
        trElement.appendChild(emailElement);

        usersTableBodyElement.appendChild(trElement);
    }
    
}
async function fetchUsers(){
    const userResponse = await fetch("/api/users");
    const usersList = await userResponse.json();
    state.users = usersList;
    
    renderUsers();
}

async function saveUser(user){
    const userResponse = await fetch("/api/users", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
});

const savedUser = await userResponse.json();
console.log("savedUser:", savedUser);
}
function main(){
    fetchUsers();
}
document.addEventListener("DOMContentLoaded", main);

function handleFormSubmit(event){
    event.preventDefault();

    const formElement = event.target;
    const formData = new FormData(formElement);

    const user = {
        firstName: formData.get(firstName),
        lastName: formData.get(lastName),
        email: formData.get(email),
    };
    console.log(user);
}