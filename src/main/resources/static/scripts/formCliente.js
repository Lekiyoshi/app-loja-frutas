const fieldsetPessoaFisica = document.getElementById("fieldsetPessoaFisica");

const fieldsetPessoaJuridica = document.getElementById("fieldsetPessoaJuridica");

document.getElementById("tipoCliente")
        .addEventListener("change", (event) => {
    let valueTipoPessoa = event.target.options[event.target.selectedIndex].value;
    
    if (valueTipoPessoa == 0) {
        fieldsetPessoaJuridica.setAttribute("disabled", "disabled");
        fieldsetPessoaJuridica.setAttribute("hidden", "hidden");
        
        fieldsetPessoaFisica.removeAttribute("disabled");
        fieldsetPessoaFisica.removeAttribute("hidden");
        
    } else if (valueTipoPessoa == 1) {
        fieldsetPessoaFisica.setAttribute("disabled", "disabled");
        fieldsetPessoaFisica.setAttribute("hidden", "hidden");
        
        fieldsetPessoaJuridica.removeAttribute("disabled");
        fieldsetPessoaJuridica.removeAttribute("hidden");
        
    }
    
});
