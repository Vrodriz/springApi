const btn = document.querySelector("#enviar")

btn.addEventListener("click", async (e) => {

  e.preventDefault();

  // Obter os valores dos campos do formulário
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const cpf = document.getElementById("cpf").value;
  const image = document.getElementById("image").value;

  // Criar um objeto de funcionário com os valores
  const newEmployee = {
    nome: name,
    email: email,
    cpf: cpf,
    imagem: "imagem"
  };
  console.log(newEmployee)
  // Enviar os dados do funcionário para a API
  fetch("http://127.0.0.1:8080/funcionario", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(newEmployee),
  })
    .then(response => response.json())
    .then(json => console.log(json))
    .catch(error => {

    });


})

const btndeletar = document.querySelector("#deletar")
btndeletar.addEventListener("click", async (e) => {
  e.preventDefault();
  const id = document.querySelector("#delete-id").value
  fetch("http://127.0.0.1:8080/funcionario/" + id, {
    method: "DELETE"
  })
    .then(response => response.json())
    .then(json => console.log(json))
    .catch(error => {

    });


})



