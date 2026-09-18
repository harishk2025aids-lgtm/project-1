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
    const userResponse = await fetch("/api/user");
    const usersList = await userResponse.json();
    state.users = usersList;
    
    renderUsers();
}

function main(){
    fetchUsers();
}
document.addEventListener("DOMContentLoaded", main);