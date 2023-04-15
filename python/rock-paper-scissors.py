import random, pygame, time
pygame.init()

WIDTH = 1000
HEIGHT = 750

win = pygame.display.set_mode((WIDTH,HEIGHT))
pygame.display.set_caption("rock, paper, scissors")


class Button():
    def __init__(self, text, color, x,y):
        self.text = text
        self.x = x
        self.y = y
        self.width = 150
        self.console_width = 600
        self.height = 80
        self.console_height = 25
        self.color = color
        BLUE = 	100,149,237
        RED = 255,0,0
        BROWN = 205,155,155


    def draw(self, win):
        pygame.draw.rect(win, (self.color),(self.x, self.y, self.width, self.height))

    def drawConsole(self, win):
        pygame.draw.rect(win, (self.color), (self.x, self.y, self.console_width, self.console_height))

    def label(self, win):
        global render_font
        font = pygame.font.SysFont("comicsans", 25)
        render_font = font.render(self.text, True, (255,255,255))
        win.blit(render_font, (self.x + self.width//2 - render_font.get_width()//2,self.y + self.height//2 - render_font.get_height()//2))

    def hitbox(self, win):
        pygame.draw.rect(win, (255,0,0), (self.x, self.y, self.width, self.height), 2)




def drawGameWindow():
    global user
    #win.fill((0,0,0))
    ButtonDrawInfo()
    drawText()
    pygame.display.update()

def ButtonDrawInfo():
    global Scissors_Button, Rock_Button, Paper_Button, console, button_width
    button_width = 150
    Scissors_Button = Button("scissors", ((100, 149, 237)), WIDTH // 3 - button_width // 2, 150)
    Rock_Button = Button("rock", (105, 89, 205), WIDTH // 2 - button_width // 2, 150)
    Paper_Button = Button("paper", (205, 155, 155), WIDTH // 1.5 - button_width // 2, 150)
    Scissors_Button.draw(win)
    Rock_Button.draw(win)
    Paper_Button.draw(win)
    Scissors_Button.label(win)
    Rock_Button.label(win)
    Paper_Button.label(win)

def drawText():
    enemy_font = pygame.font.SysFont("cambria", 25)
    render_efont = enemy_font.render("enemy choice:", True, (255, 255, 255))
    win.blit(render_efont, (WIDTH//2 - render_efont.get_width()//2, HEIGHT//2 - render_efont.get_height()//2))
    #print(pygame.font.get_fonts())



def reset():
    global user, computer, button_width
    user = 'w'
    computer = computer = random.choice(['rock', 'paper', 'scissors'])


clicking = False
def main():
    #Variables____________________________________________________________________________________________________#
    global Scissors_Button, Rock_Button, Paper_Button,user, computer, console, EnemyChoice, computer_color

    #clock
    clock = pygame.time.Clock()
    clock.tick(60)

    #user/computer
    user = 'w'
    computer = computer = random.choice(['rock', 'paper', 'scissors'])

    #drawConsole
    console_width = 600
    console = Button("hi", (131, 139, 139), WIDTH // 2 - console_width // 2, 450)

    #drawEnemyChoice
    button_width = 150
    EnemyChoice = Button("?", (84, 84, 84), WIDTH // 2 - button_width // 2, 500)
    EnemyChoice.draw(win)
    EnemyChoice.label(win)

    #font
    outcome_text = ""
    font = pygame.font.SysFont("comicsans", 15)
    render_font = font.render(outcome_text, True, (255,255,255))

    #main_loop_____________________________________________________________________________________________________#
    run = True
    while run:
        mx, my = pygame.mouse.get_pos()
        loc = [mx, my]
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False


            if event.type == pygame.MOUSEBUTTONDOWN and mx in range(Scissors_Button.x, Scissors_Button.x + Scissors_Button.width) and my in range(Scissors_Button.y, Scissors_Button.y + Scissors_Button.height):
                if event.button == 1:
                    user = 'scissors'
                    Scissors_Button.hitbox(win)

                    EnemyChoice = Button("?", (84, 84, 84), WIDTH // 2 - button_width // 2, 500)
                    EnemyChoice.draw(win)
                    EnemyChoice.label(win)

            if event.type == pygame.MOUSEBUTTONDOWN and mx in range(Rock_Button.x, Rock_Button.x + Rock_Button.width) and my in range(Rock_Button.y, Rock_Button.y + Rock_Button.height):
                if event.button == 1:
                    user = 'rock'
                    Rock_Button.hitbox(win)

                    EnemyChoice = Button("?", (84, 84, 84), WIDTH // 2 - button_width // 2, 500)
                    EnemyChoice.draw(win)
                    EnemyChoice.label(win)

            if event.type == pygame.MOUSEBUTTONDOWN and mx in range(int(Paper_Button.x), int(Paper_Button.x) + int(Paper_Button.width)) and my in range(int(Paper_Button.y), int(Paper_Button.y) + int(Paper_Button.height)):
                if event.button == 1:
                    user = 'paper'
                    Paper_Button.hitbox(win)

                    EnemyChoice = Button("?", (84, 84, 84), WIDTH // 2 - button_width // 2, 500)
                    EnemyChoice.draw(win)
                    EnemyChoice.label(win)

            pygame.display.update()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_r:
                    reset()



    #play_______________________________________________________________________________________________________#


        if winning():

            #updateButton
            computer_color = 0, 255, 0
            EnemyChoice = Button(computer, (computer_color), WIDTH // 2 - button_width // 2, 500)
            EnemyChoice.draw(win)
            EnemyChoice.label(win)
            time.sleep(2)

            print("user chose {} and computer chose {}".format(user.upper(), computer.upper()))
            print("user wins")

            reset()

        elif user == computer:

            #updateButton
            computer_color = 84, 84, 84
            EnemyChoice = Button(computer, (computer_color), WIDTH // 2 - button_width // 2, 500)
            EnemyChoice.draw(win)
            EnemyChoice.label(win)
            time.sleep(2)

            print("user chose {} and computer chose {}".format(user.upper(), computer.upper()))
            print("draw")

            reset()

        elif lose():

            #updateButton
            computer_color = 255, 0, 0
            EnemyChoice = Button(computer, (computer_color), WIDTH // 2 - button_width // 2, 500)
            EnemyChoice.draw(win)
            EnemyChoice.label(win)
            time.sleep(2)

            print("user chose {} and computer chose {}".format(user.upper(), computer.upper()))
            print("user loses")

            reset()

        drawGameWindow()
    pygame.quit()



def winning():
    global computer_color, EnemyChoice
    if (user == 'rock' and computer == 'scissors') or (user == 'paper' and computer == 'rock') or (user == 'scissors' and computer == 'paper'):
        return True


def lose():
    global computer_color
    if (user == 'rock' and computer == 'paper') or (user == 'paper' and computer == 'scissors') or (user == 'scissors' and computer == 'rock'):
        return True


if __name__ == "__main__":
    main()
