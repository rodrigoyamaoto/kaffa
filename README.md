# kaffa

## Este projeto possui três funcionalidades:

- **Validar formato do CNPJ:** Verifica se o CNPJ digitado esta no formato xx.xxx.xxx/xxxx-xx ou xxxxxxxxxxxxxx
- **Validar os digitos verificadores do CNPJ:** Dado um CNPJ ele irá verificar se ele é valido ou não através dos digitos verificadores, foi utilizado a seguinte regra para verificar os digitos https://campuscode.com.br/conteudos/o-calculo-do-digito-verificador-do-cpf-e-do-cnpj
- **Rest Client:** Faz uma requisição Get ao site http://worldclockapi.com/api/json/utc/now e retorna a hora atual no timezone local e no UTC
