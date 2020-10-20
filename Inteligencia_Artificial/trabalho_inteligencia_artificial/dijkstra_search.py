

class Dijkstra:

    def __init__(self, grafico, start, goalNode):
        self.visitados = []
        self.lista = []
        self.custos = {}
        self.pai = {}
        self.caminho = []
        self.grafico = grafico
        self.start = start
        self.goalNode = goalNode

    def iniciarBusca(self):
        self.dijkstra()
        self.clear()

    def dijkstra(self):

        self.lista.append(self.start)

        if self.start.__eq__(self.goalNode):
            return self.start

        for vertice in self.grafico.keys():
            self.custos[vertice] = float('inf')  # inicia os vertices como infinito

        self.custos[self.start] = 0
        self.pai[self.start] = self.start

        while self.lista:
            atual = self.lista.pop(0)
            self.visitados.append(atual)

            #if atual.__eq__(goalNode):
                #break

            if self.grafico[atual].__len__() > 0:
                for filho in self.grafico[atual]:
                    if not self.visitados.__contains__(filho):
                        self.lista.append(filho)
                    if self.custos[filho] > (self.custos[atual] + self.grafico[atual].get(filho)):
                        self.custos[filho] = self.custos[atual] + self.grafico[atual].get(filho)
                        self.pai[filho] = atual

        caminho = self.encontrar_caminho(self.start, self.goalNode, self.pai)
        self.mostrar_caminho(caminho, self.goalNode)

    def encontrar_caminho(self, start, goalNode, pai):
        caminho = [goalNode]
        atual = pai[goalNode]
        while True:
            caminho.append(atual)
            if atual.__eq__(start):
                break
            atual = pai[atual]
        return caminho

    def mostrar_caminho(self, caminho, goalNode):

        for i in reversed(range(len(caminho))):
            if i > 0:
                print(caminho[i], ' --> ', end=" ")
            else:
                print(caminho[i])
        print("O custo da viagem foi de", self.custos[goalNode])

    def clear(self):
        self.visitados.clear()
        self.lista.clear()
        self.custos.clear()
        self.pai.clear()
        self.caminho.clear()
