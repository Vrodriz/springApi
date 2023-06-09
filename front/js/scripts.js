function addEmployee(event) {
  event.preventDefault();

  // Obter os valores dos campos do formulário
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const cpf = document.getElementById("cpf").value;
  const image = document.getElementById("image").value;

  // Criar um objeto de funcionário com os valores
  const newEmployee = {
    name: name,
    email: email,
    cpf: cpf,
    image: image,
  };

  // Enviar os dados do funcionário para a API
  fetch("http://127.0.0.1:8080/funcionario", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(newEmployee),
  })
    .then(response => response.json())
    .then(data => {
      // Verificar a resposta da API e fazer as ações necessárias
      if (data.success) {
        // Funcionário adicionado com sucesso
        employees.push(newEmployee);
        updateEmployeeList();
        addEmployeeForm.reset();
      } else {
        // Ocorreu um erro ao adicionar o funcionário
        console.error(data.message);
      }
    })
    .catch(error => {
      console.error("Ocorreu um erro ao conectar à API:", error);
    });
}
