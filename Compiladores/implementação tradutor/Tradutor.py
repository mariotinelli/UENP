class Pilha(object):
    def __init__(self):
        self.dados = []

    def empilha(self, elemento):
        self.dados.append(elemento)

    def desempilha(self):
        if not self.vazia():
            return self.dados.pop(-1)

    def vazia(self):
        return len(self.dados) == 0


class Token:
    def __init__(self):
        self.type = 0
        self.value = 0

    def setType(self, type):
        self.type = type

    def setValue(self, value):
        self.value = value

    def getType(self):
        return self.type

    def getValue(self):
        return self.value


NUMBER = 256
SYMBOL = 257


class Tradutor:
    pos = -1
    peek = ''
    lookahead = Token()
    pilha = Pilha()

    def __init__(self, entrada):
        self.entrada = entrada

    def Lookahead(self, lookahead):
        self.lookahead = lookahead

    def nextChar(self):
        if self.pos == -1:
            self.pos = 0
        elif self.pos == len(self.entrada):
            return
        aux = self.entrada[self.pos]
        self.pos += 1
        return aux

    def scan(self):
        t = Token()
        v = 0
        if self.peek != ' ' and self.peek != '\\t' and self.peek != '\\n' and self.pos > 0:
            pass
        else:
            for self.peek in self.nextChar():
                if self.peek != ' ' and self.peek != '\\t' and self.peek != '\\n':
                    break
        if str(self.peek).isdigit():
            v = 0
            while str(self.peek).isdigit():
                v = 10 * v + int(self.peek)
                self.peek = self.nextChar()

            t.setType(NUMBER)
            t.setValue(v)
            return t
        t.setType(SYMBOL)
        t.setValue(self.peek)
        self.peek = ' '
        return t

    def match(self, t):
        if self.lookahead.getType() == t.getType() and self.lookahead.getValue() == t.getValue():
            self.lookahead = self.scan()
        else:
            print("\n*** Syntax Error! Values do not match. *** \n")
            exit(0)

    def term(self):
        if self.lookahead.getType() == NUMBER:
            v = int(self.lookahead.getValue())
            self.pilha.empilha(v)
            print(v, end=" ")
            self.match(self.lookahead)
        else:
            print("\n*** Syntax Error! '%c' it's not a number. ***\n", self.lookahead.getValue())
            exit(0)

    def inicializa(self):
        while True:
            if self.lookahead.getType() == NUMBER:
                self.term()
            elif self.lookahead.getType() == SYMBOL:
                self.exprSomaSub()
                self.exprDivMult()
                return

    def exprSomaSub(self):
        while True:
            if self.lookahead.getValue() == '+':
                aux = self.lookahead.getValue()
                self.match(self.lookahead)
                self.inicializa()
                topoPilha = self.pilha.desempilha()
                topo2 = self.pilha.desempilha()
                self.pilha.empilha(topo2 + topoPilha)
                self.exprSomaSub()
                print(aux, end=" ")

            elif self.lookahead.getValue() == '-':
                aux = self.lookahead.getValue()
                self.match(self.lookahead)
                self.inicializa()
                topoPilha = self.pilha.desempilha()
                topo2 = self.pilha.desempilha()
                self.pilha.empilha(topo2 - topoPilha)
                self.exprSomaSub()
                print(aux, end=" ")
            else:
                return

    def exprDivMult(self):
        # v = self.term()
        #  print(v)
        while True:
            #  print(lookahead.getType())
            if self.lookahead.getType() == SYMBOL:
                if self.lookahead.getValue() == '*':
                    aux = self.lookahead.getValue()
                    self.match(self.lookahead)
                    self.term()
                    topoPilha = self.pilha.desempilha()
                    topo2 = self.pilha.desempilha()
                    self.pilha.empilha(topo2 * topoPilha)
                    self.exprDivMult()
                    print(aux, end=" ")

                elif self.lookahead.getValue() == '/':
                    aux = self.lookahead.getValue()
                    self.match(self.lookahead)
                    self.term()
                    topoPilha = self.pilha.desempilha()
                    topo2 = self.pilha.desempilha()
                    self.pilha.empilha(topo2 / topoPilha)
                    self.exprDivMult()
                    print(aux, end=" ")

                else:
                    return
            else:
                self.term()


if __name__ == '__main__':
    # entrada = input("Expression: ")
    tradutor = Tradutor("122*100")
    tradutor.Lookahead(tradutor.scan())
    tradutor.inicializa()
    x = tradutor.pilha.desempilha()
    print("\n")
    print("Result: ", x)
