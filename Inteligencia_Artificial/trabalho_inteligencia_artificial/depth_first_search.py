
from trabalho_inteligencia_artificial.mostra_caminho import MostraCaminho


class DepthFirst:

    def __init__(self, grafico, start, goalNode):
        self.caminho = MostraCaminho()
        self.pais = {}
        self.visitados = []
        self.lista = []
        self.filhos = []
        self.grafico = grafico
        self.start = start
        self.goalNode = goalNode

    def iniciarBusca(self):
        self.depth_first()
        self.clear()

    def depth_first(self):

        if self.busca(self.start):
            self.caminho.mostra_caminho(self.start, self.goalNode, self.pais)
        else:
            print('Não encontrado')

    def busca(self, start):

        self.visitados.append(start)
        self.lista.append(start)
        pai = self.lista.pop(0)

        if pai.__eq__(self.goalNode):
            return True

        for filho in self.grafico[pai]:
            if not self.visitados.__contains__(filho):
                self.pais[filho] = pai
                if self.busca(filho):
                    return True
        return False

    def clear(self):
        self.pais.clear()
        self.visitados.clear()
        self.lista.clear()
        self.filhos.clear()
