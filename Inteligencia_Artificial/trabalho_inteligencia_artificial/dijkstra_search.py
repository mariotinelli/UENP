class Dijkstra:

    def __init__(self, grafo, start, goalNode):
        self.visitados = []
        self.listaAdj = []
        self.custos = {}
        self.caminho = {}
        self.grafo = grafo
        self.start = start
        self.goalNode = goalNode

    def iniciarBusca(self):
        self.dijkstra()
        self.mostrar_caminho(self.caminho)
        self.clear()

    def dijkstra(self):

        self.listaAdj.append(self.start)

        if self.start.__eq__(self.goalNode):
            return self.start

        for vertice in self.grafo.keys():
            self.custos[vertice] = float('inf')  # inicializa o dicionarios custos em todas as keys como infinito.

        self.custos[self.start] = 0

        while self.listaAdj:
            cidadeAtual = self.listaAdj.pop(0)
            self.visitados.append(cidadeAtual)

            if self.grafo[cidadeAtual].__len__() > 0:
                for filho in self.grafo[cidadeAtual]:
                    if not self.visitados.__contains__(filho):
                        self.listaAdj.append(filho)
                        # custos[Zerind] = 'inf' > custos[cidadeAtual] =  0 + grafo[cidadeAtual].get(Zerind)) = 75 ?
                        # Verifica se o custo na key filho é maior que o custo somado com a key da cidAtual + o custo da cidAtual p/ seu filho
                    if self.custos[filho] > (self.custos[cidadeAtual] + self.grafo[cidadeAtual].get(filho)):
                        self.custos[filho] = self.custos[cidadeAtual] + self.grafo[cidadeAtual].get(filho)
                        self.caminho[filho] = cidadeAtual

    def mostrar_caminho(self, caminho):
        print('Caminho:', end=' ')
        cidadePai = self.goalNode
        while True:
            print(cidadePai, end=" -> ")
            if cidadePai == self.start:
                break
            cidadePai = caminho[cidadePai]
        print("com custo de", self.custos[self.goalNode])

    def clear(self):
        self.visitados.clear()
        self.listaAdj.clear()
        self.custos.clear()
        self.caminho.clear()


"""from create_grafo import Grafo

create = Grafo()
Dijkstra(create.criaGrafoCusto(), "Arad", "Bucharest").iniciarBusca()"""
