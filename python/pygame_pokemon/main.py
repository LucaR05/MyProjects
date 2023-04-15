import pygame, sys, time, pickle

pygame.init()
#next = back button, print pokedex button
WIDTH = 800
HEIGHT = 800

clock = pygame.time.Clock()
screen = pygame.display.set_mode([WIDTH, HEIGHT])

#create font
base_font = pygame.font.Font(None,32)
user_text = ''

#create rectangle   Rect(x,y,width,height)
input_rect = pygame.Rect(WIDTH/2 - 250/2,HEIGHT/2 - 100 ,140,32)
color_active = pygame.Color('lightskyblue3')
color_passive = pygame.Color('gray15')
color = color_passive 

active = False

pokemon = []
pickle.dump(pokemon, open("pokemon.txt", "wb"))

pokedex = pickle.load(open("pokedex.txt", "rb"))

add_pokemon = False
delete_pokemon = False
count_pokemon = False
search_pokemon = False
index_info = False


#Button Class -------------------------------------------------------------------------------------
class Button:
    def __init__(self, text, color, x, y, width, height):
        self.text = text
        self.color = color 
        self.x = x
        self.y = y 
        self.width = width 
        self.height = height
        self.border_color = ("ivory")

    def create(self):
        pygame.draw.rect(screen, self.color, (self.x, self.y, self.width, self.height))
    
    def border(self):
        pygame.draw.rect(screen, self.border_color, (self.x, self.y, self.width, self.height), 2)
    


#Creating Buttons
color_blue = "lightskyblue"
color_grey = "grey"

add_Button = Button("add", "grey", input_rect.x + input_rect.width + 70, input_rect.y , 75, 30)
pokedex_button = Button("pokedex", "lightskyblue", add_Button.x, add_Button.y + 50, 75, 30)
back_button = Button("back", "grey", input_rect.x - 85, input_rect.y, 75, 30)


#Text Class ----------------------------------------------------------------------------------------
class Text:
    def __init__(self, color, text, size=int):
        self.color = color
        self.text = text 
        self.size = size

    def create(self, x_pos, y_pos):
        font = pygame.font.SysFont("comicsans", self.size)
        render = font.render(self.text, True, self.color)
        screen.blit(render, (x_pos, y_pos))


#creating Texts
choose_action = Text('ivory', "What do you want to do?", 15)
title = Text('ivory', "POKEDEX", 35)
functions_x = WIDTH/2 - 100
functions_text = Text("red","functions: ", 15)
function1 = Text("red", "add: adds a pokemon",15 )
function2 = Text("red", "delete: deletes Pokemon after Index", 15)
delete_info_header = Text("red", "delete options:", 15)
delete_info_1 = Text("red", "'all' to remove every pokemon", 15)
delete_info_2 = Text("red", "'last' to remove last added pokemon", 15)
delete_info_3 = Text("red", "[index] to remove pokemon after index", 15)
add_info = Text("red", "press 'Button Up' to continue", 15)
add_Button_text = Text("white", add_Button.text, 20 )
pokedex_button_text = Text("white", pokedex_button.text, 18)
back_button_text = Text("white", back_button.text, 20)
function3 = Text('red', 'count: counts your Pokemon!', 15)
function4 = Text('red', 'search: searches for a Pokemon!', 15)
#pokemon1Name = Text('yellow',  pokedex[0][0], 15)


#function to collect and draw
def draw():
    choose_action.create(input_rect.x ,input_rect.y - 23)
    title.create(input_rect.x + 25, 50)
    add_Button.create()
    add_Button_text.create(add_Button.x + 17, add_Button.y )
    add_Button.border()
    pokedex_button.create()
    pokedex_button_text.create(pokedex_button.x + 2, pokedex_button.y)
    pokedex_button.border()
    back_button.create()
    back_button.border()
    back_button_text.create(back_button.x + 15, back_button.y)
    #pokemon1Name.create(20, HEIGHT- 50)
    if add_pokemon == False and delete_pokemon == False and search_pokemon == False:
        functions_text.create(WIDTH//2 - 50, 400)
        function1.create(WIDTH//2 - 80, 420)
        function2.create(WIDTH//2 - 120, 440)
        function3.create(WIDTH//2 - 100, 460)
        function4.create(WIDTH//2 - 100,  480)
        
    elif delete_pokemon == True:
        delete_info_header.create(WIDTH//2-80, 400)
        delete_info_1.create(WIDTH//2 - 130, 420)
        delete_info_2.create(WIDTH//2 - 130, 440)
        delete_info_3.create(WIDTH//2 - 130, 460)

    elif add_pokemon == True:
        add_info.create(WIDTH//2-100, 400)

    if index_info == True: 
       height_pokemonText = 600
       pokemonName.create(30, height_pokemonText)
       pokemonType.create(30, height_pokemonText + 25)
       pokemonLevel.create(30, height_pokemonText + 50)


#Search-function
def test_a(string):
    global foundIndex, name_, type_, level_, pokemonName, pokemonType, pokemonLevel
    for i in pokedex:
        if string in i:
            print(i)
            name_ = (i[0])
            type_ = (i[1])
            level_ = (i[2])
            foundIndex = pokedex.index(i)
            pokemonName = Text('yellow', name_, 15)
            pokemonType = Text('yellow', type_, 15)
            pokemonLevel = Text('yellow', level_, 15)


     

while True:
    mx,my = pygame.mouse.get_pos()
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()



#Checking for Keypresses -------------------------------------------------------------

        if event.type == pygame.MOUSEBUTTONDOWN:
            if input_rect.collidepoint(event.pos):
                active = True
            else:
                active = False

        if event.type == pygame.KEYDOWN:
            if active == True:
                if event.key == pygame.K_BACKSPACE:
                    user_text = user_text[:-1]
                else:
                    user_text += event.unicode

            if event.key == pygame.K_RIGHT:
                pokemon = pickle.load(open("pokemon.txt", "rb"))
                print(pokemon)
            if event.key == pygame.K_UP and add_pokemon:
                pokemon.append(user_text)
                pickle.dump(pokemon, open("pokemon.txt", "wb"))
                user_text = ""

        if event.type == pygame.MOUSEBUTTONDOWN and mx in range(pokedex_button.x, pokedex_button.x +  pokedex_button.width) and my in range(pokedex_button.y, pokedex_button.y + pokedex_button.height):
                pokedex = pickle.load(open("pokedex.txt", "rb"))
                print(pokedex)

        if event.type == pygame.MOUSEBUTTONDOWN and mx in range(add_Button.x, add_Button.x + add_Button.width) and my in range(add_Button.y, add_Button.y + add_Button.height)  and add_pokemon:
            if add_Button.color == "lightskyblue":
                pokedex.append(pokemon)
                pickle.dump(pokedex, open("pokedex.txt", "wb"))
                pokemon = []
                pickle.dump(pokemon, open("pokemon.txt", "wb"))

        if event.type == pygame.MOUSEBUTTONDOWN and mx in range(back_button.x, back_button.x + back_button.width) and my in range(back_button.y, back_button.y + back_button.height):
            if back_button.color == "lightskyblue":
                choose_action.text = "What do you want to do?"
                user_text = ""
                choose_action.create(input_rect.x ,input_rect.y - 23)
                add_pokemon = False
                delete_pokemon = False
                count_pokemon = False
                search_pokemon = False
                index_info = False
                back_button.color = color_grey
            

#Adding/Deleting Pokemon to the/from the Pokedex --------------------------------------
        if add_pokemon == True:
            add_Button.color = color_grey
            choose_action.text = "Whats the name of the pokemon"
            choose_action.create(input_rect.x ,input_rect.y - 23)
            if len(pokemon) == 1:
                choose_action.text = "Whats the type of the pokemon"
                choose_action.create(input_rect.x ,input_rect.y - 23)
            if len(pokemon) == 2:
                choose_action.text = "Whats the level of the pokemon"
                choose_action.create(input_rect.x ,input_rect.y - 23)
            if len(pokemon) == 3:
                add_Button.color = color_blue
                choose_action.text = "Congrats! Save your pokemon with the 'add Button'"
                choose_action.create(300, input_rect.y - 23)


        if delete_pokemon == True:
            choose_action.text = "What Index do you want to delete?"
            choose_action.create(input_rect.x ,input_rect.y - 23)
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    if user_text == "all":
                        pokedex = []
                        pickle.dump(pokedex, open("pokedex.txt", "wb"))
                    elif user_text == "last":
                        choose_action.text = "The Pokemon " + pokedex[len(pokedex)-1][0] + " has been deleted"
                        choose_action.create(input_rect.x ,input_rect.y - 23)
                        pokedex.pop()
                        pickle.dump(pokedex, open("pokedex.txt", "wb"))
                    else:
                        try:
                            del pokedex[int(user_text)]
                            pickle.dump(pokedex, open("pokedex.txt", "wb"))
                        except ValueError:
                            print("not an int")

        if count_pokemon == True:
            choose_action.text = "you have " + str(len(pokedex)) + " beloved pokemon"
            choose_action.create(input_rect.x, input_rect.y - 23)

        if add_pokemon == True or delete_pokemon == True or count_pokemon == True or search_pokemon == True:
            back_button.color = color_blue 

        if search_pokemon == True:
            choose_action.text = "search for a keyword"
            choose_action.create(input_rect.x ,input_rect.y - 23)
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    if user_text != "":
                        test_a(user_text)
                        index_info = True

        if index_info == True:
            choose_action.text = "Pokemon found at index " + str(foundIndex) + "."
            choose_action.create(300, input_rect.y - 23)

                        
        

    screen.fill((0,0,0))
    pikachu = pygame.image.load('pikachu_image.png')
    screen.blit(pikachu, [240,500])

#setting the conditions 
    if user_text == "add":
        add_pokemon = True
        delete_pokemon = False
        count_pokemon = False
        search_pokemon = False
        index_info = False
        user_text = ""

    if user_text == "delete":
        delete_pokemon = True
        add_pokemon = False
        count_pokemon = False
        search_pokemon = False
        index_info = False
        user_text = ""

    if user_text == "count":
        count_pokemon = True
        add_pokemon = False
        delete_pokemon = False 
        search_pokemon = False
        index_info = False
        user_text = ""

    if user_text == "search":
        search_pokemon = True
        count_pokemon = False
        add_pokemon = False
        delete_pokemon = False 
        index_info = False
        user_text = ""

    

    draw()

    if active:
        color = color_active
    else:
        color = color_passive

    pygame.draw.rect(screen,color,input_rect,2)

    text_surface = base_font.render(user_text, True,(255,255,255))
    screen.blit(text_surface,(input_rect.x + 5, input_rect.y + 5))

    input_rect.w = max(200,text_surface.get_width() + 10)



    pygame.display.flip()
    clock.tick(60)

