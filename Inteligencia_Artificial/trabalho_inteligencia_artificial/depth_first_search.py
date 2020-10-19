

class DepthFirst:

    from trabalho_inteligencia_artificial.mostra_caminho import MostraCaminho

    caminho = MostraCaminho()
    pais = {}
    visitados = []
    lista = []
    filhos = []

    def depth_first(self, grafico, start, goalNode):

        if self.busca(grafico, start, goalNode):
            self.caminho.mostra_caminho(start, goalNode, self.pais)
        else:
            print('Não encontrado')

    def busca(self, grafico, start, goalNode):

        self.visitados.append(start)
        self.lista.append(start)
        pai = self.lista.pop(0)

        if pai.__eq__(goalNode):
            return True

        for filho in grafico[pai]:
            if not self.visitados.__contains__(filho):
                self.pais[filho] = pai
                if self.busca(grafico, filho, goalNode):
                    return True
        return False
