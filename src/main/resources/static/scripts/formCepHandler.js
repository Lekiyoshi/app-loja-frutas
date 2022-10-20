const viacep = new XMLHttpRequest();

const cepCharRegex = new RegExp("\\d");

function limparDados() {
    document.getElementById("logradouro").value = "";
    document.getElementById("bairro").value = "";
    document.getElementById("cidade").value = "";
    document.getElementById("uf").value = "";
}

document.getElementById("cep")
        .addEventListener("change", (event) => {
    let novoCep = event.target.value;
    
    // Campo vazio
    if (!novoCep) {
        limparDados();
        
        return;
    }
    
    novoCep = novoCep.replace(/[\D]/g, "")
    
    // Formato de CEP inválido
    if (novoCep.length != 8) {
        alert("O CEP precisa conter 8 dígitos. Formato: 00000-000");
        limparDados();
        
        return;
    }
    
    // Formato de CEP validado, será usado no request
    viacep.open('GET', "https://viacep.com.br/ws/" + novoCep + "/json/");
    viacep.responseType = 'json';
    
    viacep.onload = function() {
        let status = viacep.status;
        
        // Erro de status de resposta ou CEP não foi encontrado
        if (status !== 200 || viacep.response["erro"]) {
            limparDados();
            
            return;
        }
        
        document.getElementById("logradouro").value = viacep.response["logradouro"];
        document.getElementById("bairro").value = viacep.response["bairro"];
        document.getElementById("cidade").value = viacep.response["localidade"];
        document.getElementById("uf").value = viacep.response["uf"];
        
    }
    
    viacep.send();
    
    document.getElementById("logradouro").value = "...";
    document.getElementById("bairro").value = "...";
    document.getElementById("cidade").value = "...";
    document.getElementById("uf").value = "...";
    
});

document.getElementById("cep")
        .addEventListener("keydown", (event) => {
    // Continuar a função apenas se a tecla digita um caractere
    if (event.ctrlKey
    || event.altKey
    || typeof event.key !== 'string'
    || event.key.length !== 1) {
        return;
    }
    
    // Limitar o CEP para 9 caracteres (8 dígitos e 1 hífen)
    if (!cepCharRegex.test(event.key)
    || event.target.value.length === 9) {
        event.preventDefault();
    }
    
    // Adicionar o hífen automaticamente após 5 dígitos
    if (event.target.value.length === 5) {
        event.target.value = event.target.value + "-";
    }
    
});
