from trabalho_inteligencia_artificial.mostra_caminho import MostraCaminho


class DepthFirstLimited:

    def __init__(self, grafico, start, goalNode, limit = 0):
        self.limit = limit
        self.caminho = MostraCaminho()
        self.pais = {}
        self.visitados = []
        self.lista = []
        self.limites = {}
        self.grafico = grafico
        self.start = start
        self.goalNode = goalNode
        #self.limit = 0

    def iniciarBusca(self):
        self.limit = int(input('Digite um limite para sua busca: '))
        self.depthfirst_limited()
        self.clear()

    def depthfirst_limited(self):
        if self.busca(self.start):
            self.caminho.mostra_caminho(self.start, self.goalNode, self.pais)
        else:
            print('Não encontrado')

    def busca(self, start, limite=0):

        self.visitados.append(start)
        self.lista.append(start)
        pai = self.lista.pop(0)

        if limite == 0:
            self.limites[pai] = limite

        if pai.__eq__(self.goalNode):
            return True

        if self.limites[pai] == self.limit:
            return

        if len(self.grafico[pai]) > 0:
            limite += 1
            for filho in self.grafico[pai]:
                if not self.visitados.__contains__(filho):
                    self.limites[filho] = self.limites[pai] + 1
                    self.pais[filho] = pai
                    if self.busca(filho, self.limites[filho]):
                        return True

        return False

    def clear(self):
        self.lista.clear()
        self.pais.clear()
        self.visitados.clear()
        self.limites.clear()
