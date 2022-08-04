# ESTUDO DE ORIENTAÇÃO A OBJETO COM `INTERFACE`
Repositório dedicado a aprender sobre orientação a objetos com interfaces, composição, polimorfismo em muitos níveis

## QUESTÃO PROBLEMA #01

Uma empresa deseja automatizar o processamento de seus contratos. O processamento de um contrato consiste em gerar as parcelas a serem pagas para aquele `contrato`, com base no número de meses desejado.

A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas. Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa por pagamento. **Por enquanto**, o serviço contratado pela empresa é o do Paypal, que aplica juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.

Faça um programa que leia os dados de um contrato (número do contrato, data do contrato, e valor total do contrato). Em seguida, o programa deve ler o número de meses para parcelamento do contrato, gerar os registros de parcelas a serem pagas (data e valor), sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela.

Exemplo de como deverá ser a impressão no console:

![image](https://user-images.githubusercontent.com/78989152/182848602-fd82511e-fc6d-4ec1-9a3e-a0ca79d5561c.png)

## DIAGRAMA DE CLASSES

### Serviços
![image](https://user-images.githubusercontent.com/78989152/182858760-da7e9e27-7659-43b8-a247-68c254d0ef32.png)

### Entidades
![image](https://user-images.githubusercontent.com/78989152/182859025-4b078366-0cc2-4c6a-8318-76f97332a412.png)

