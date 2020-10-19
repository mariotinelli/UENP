

class Dijkstra:

    visitados = []
    lista = []
    custos = {}
    pai = {}
    caminho = []

    def dijkstra(self, grafo, start, goalNode):

        self.lista.append(start)

        if start.__eq__(goalNode):
            return start

        for vertice in grafo.keys():
            self.custos[vertice] = float('inf')  # inicia os vertices como infinito

        self.custos[start] = 0
        self.pai[start] = start

        while self.lista:
            atual = self.lista.pop(0)
            self.visitados.append(atual)

            #if atual.__eq__(goalNode):
                #break

            if grafo[atual].__len__() > 0:
                for filho in grafo[atual]:
                    if not self.visitados.__contains__(filho):
                        self.lista.append(filho)
                    if self.custos[filho] > (self.custos[atual] + grafo[atual].get(filho)):
                        self.custos[filho] = self.custos[atual] + grafo[atual].get(filho)
                        self.pai[filho] = atual

        caminho = self.encontrar_caminho(start,goalNode, self.pai)
        self.mostrar_caminho(caminho, goalNode)

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


#dj = Dijkstra()
#dj.dijkstra(dj.grafo, 'Bucharest', 'Arad')

