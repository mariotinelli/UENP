

class Grafo:

    def criaGrafoCusto(self):

        grafo = {}

        arquivo = open('grafo.txt', 'r')
        texto = arquivo.readlines()
        pai_anterior = texto[0].split()[0]

        contagem_pai = 0
        contagem_filhos = 0
        inicio = 0
        teste = []
        custos = []
        cidade_filho = []

        for linha in texto:

            linha_split = linha.split(' ')
            pai = linha_split[0]
            filho = linha_split[1]
            custo = int(linha_split[2])
            add_filhos = {}

            if pai.__eq__(pai_anterior):
                cidade_filho.append(filho)
                custos.append(custo)
                contagem_filhos += 1
            else:
                cidade_filho.append(filho)
                custos.append(custo)
                while inicio < contagem_filhos:
                    add_filhos[cidade_filho[inicio]] = custos[inicio]
                    inicio += 1
                teste.append(add_filhos)

                del add_filhos
                grafo[pai_anterior] = teste[contagem_pai]
                pai_anterior = pai
                inicio = contagem_filhos
                contagem_filhos += 1
                contagem_pai += 1

            if pai.__eq__('Eforie'):
                grafo[pai] = {filho: custo}

        return grafo

    def criaGrafo(self):
        grafo = {}

        arquivo = open('grafo.txt', 'r')
        texto = arquivo.readlines()
        pai_anterior = texto[0].split()[0]

        cidade_filho = []
        contagem_filhos = 0
        inicio = 0

        for linha in texto:
            linha_split = linha.split(' ')
            pai = linha_split[0]
            filho = linha_split[1]

            if pai.__eq__(pai_anterior):
                cidade_filho.append(filho)
                contagem_filhos += 1
            else:
                cidade_filho.append(filho)
                grafo[pai_anterior] = cidade_filho[inicio:contagem_filhos]
                pai_anterior = pai
                inicio = contagem_filhos
                contagem_filhos += 1
        grafo[pai_anterior] = cidade_filho[inicio:contagem_filhos]
        return grafo

    def printGrafo(self, grafo):
        for i in grafo:
            print(i, "->", grafo[i])

