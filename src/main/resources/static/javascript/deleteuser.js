const HOMEPAGE = "http://localhost:8080/";
const form = document.getElementById("deleteform");
const deleteButton = document.getElementById("deleteuser");

deleteButton.addEventListener("click", (ev) => {
    fetch(form.action, {
        method: "DELETE"
    }).then(() => {
        window.location = HOMEPAGE;
    });
});