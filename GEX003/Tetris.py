import pygame, sys, os, random

class colors:
    black,blue,lime,aqua,red,magenta,yellow,white = [(r,g,b) for r in (0,255) for g in (0,255) for b in (0,255)]
    black,navy,green,teal,maroon,purple,olive,grey = [(r,g,b) for r in (0,128) for g in (0,128) for b in (0,128)]
    pink    = (255,192,203)
    gold    = (255,215,0)
    orange  = (255,102,0)
    lblue   = (102,204,255)
    llblue  = (190,207,234)
    lllblue = (180,197,223)
    lpurple = (204,0,255)

class fonts:
    default    = lambda size: pygame.font.Font(None,                                             size)
    ardestine  = lambda size: pygame.font.Font("C:\Windows\Fonts\ARDESTINE.TTF",                 size)
    arial      = lambda size: pygame.font.Font("C:\Windows\Fonts\Arial.TTF",                     size)
    coderscrux = lambda size: pygame.font.Font("C:\Windows\Fonts\Coder's Crux Regular.TTF",      size)
    mario      = lambda size: pygame.font.Font("C:\Windows\Fonts\Super Mario Bros. Regular.TTF", size)
    beast      = lambda size: pygame.font.Font("C:\Windows\Fonts\Beast Machines.TTF",            size)

class key:
    state = lambda key: pygame.key.get_pressed()[eval('pygame.K_'+key)]
    up    = lambda key: [0 for event in main.event if event.type==pygame.KEYUP and event.key==eval('pygame.K_'+key)]
    down  = lambda key: [0 for event in main.event if event.type==pygame.KEYDOWN and event.key==eval('pygame.K_'+key)]

class mouse:
    state     = lambda button: pygame.mouse.get_pressed()[button-1]
    up        = lambda button: [0 for event in main.event if event.type==pygame.MOUSEBUTTONUP and event.button==button]
    down      = lambda button: [0 for event in main.event if event.type==pygame.MOUSEBUTTONDOWN and event.button==button]
    motion    = lambda: [0 for event in main.event if event.type==pygame.MOUSEMOTION]
    rel       = lambda: pygame.mouse.get_rel()
    in_window = lambda: pygame.mouse.get_focused()
    def pos(pos=None): return pygame.mouse.set_pos(pos) if pos else pygame.mouse.get_pos()
    def visible(state=None):
        if state!=None: pygame.mouse.set_visible(state)
        elif pygame.mouse.set_visible(0): pygame.mouse.set_visible(1); return True

def exitgame(): pygame.quit(); sys.exit()

class setup:
    def __init__(self, size, title, fps):
        pygame.init()
        os.environ["SDL_VIDEO_CENTERED"] = "1"
        pygame.display.set_caption(title)
        self.screen, self.fullscreen, self.clock, self.fps = pygame.display.set_mode(size), False, pygame.time.Clock(), fps
        self.resetmenus()

    def events(self):
        if not self.paused: self.resetmenus()
        if self.options: self.optionsmenu()
        elif self.quit: self.quitmenu()
        elif self.paused: self.pausemenu()
        
        pygame.display.flip()
        self.clock.tick(self.fps)
        self.screen.fill(colors.white)
        if pygame.event.get(pygame.QUIT): exitgame()
        self.event = pygame.event.get()

        if key.down("p") or mouse.down(2): self.paused = False if self.paused else True
        if key.state("LALT") and key.down("RETURN"): self.toggle_fullscreen()
        if key.state("LALT") and key.down("F4"): exitgame()

    def toggle_fullscreen(self):
        if self.fullscreen: self.fullscreen, self.screen = False, pygame.display.set_mode(self.screen.get_size())
        else: self.fullscreen, self.screen = True, pygame.display.set_mode(self.screen.get_size(), pygame.FULLSCREEN)

    def resetmenus(self): self.current, self.paused, self.quit, self.options = 0, False, False, False

    def menu(self, selections):
        texts = [fonts.beast(i[2]).render(i[0], True, colors.grey, colors.black) for i in selections]
        [self.screen.blit(texts[i], center((self.screen.get_rect().centerx,selections[i][1]),texts[i].get_size())) for i in range(len(selections))]

        text = fonts.beast(selections[self.current][2]).render(selections[self.current][0], True, colors.yellow, colors.black)
        self.screen.blit(text,center((self.screen.get_rect().centerx,selections[self.current][1]),text.get_size()))
        
        if key.down("w"): self.current = (self.current-1)%len(selections)
        if key.down("s"): self.current = (self.current+1)%len(selections)
        if key.down("RETURN"): exec(selections[self.current][3])
        
        for i in range(len(selections)):
            if pygame.Rect((self.screen.get_rect().centerx-texts[i].get_rect().centerx,selections[i][1]-texts[i].get_rect().centery),texts[i].get_size()).collidepoint(mouse.pos()):
                if mouse.motion(): self.current = i
                if mouse.up(1): exec(selections[i][3])

    def pausemenu(self):
        self.menu([ ["Resume Game", 180, 20, "self.paused, self.current = False, 0"],
                    ["Options",     280, 20, "self.options, self.current = True, 0"],
                    ["Quit Game",   380, 20, "self.quit, self.current = True, 0"], ])

    def optionsmenu(self):
        text = fonts.beast(25).render("Options", True, colors.lime, colors.black)
        self.screen.blit(text, center((self.screen.get_rect().centerx,120),text.get_size()))
        self.menu([ ["Fullscreen: "+str(self.fullscreen), 220, 20, "self.toggle_fullscreen()"],
                    ["Back",                              320, 20, "self.options, self.current = False, 0"], ])

    def quitmenu(self):
        text = fonts.beast(25).render("Are You Sure?", True, colors.lime, colors.black)
        self.screen.blit(text, center((self.screen.get_rect().centerx,120),text.get_size()))
        self.menu([ ["No",  220, 20, "self.quit, self.current = False, 0"],
                    ["Yes", 320, 20, "exitgame()"], ])

def center(a,b): return (a[0]-b[0]/2,a[1]-b[1]/2)

class grid:
    def __init__(self, gs, ps, ms, speed):
        self.active = False
        self.gs, self.ps, self.ms, self.speed = gs, ps, ms, speed
        self.rect = pygame.Rect(0, 0, ms[0]+gs[0]*(ps[0]+ms[0]), ms[1]+gs[1]*(ps[1]+ms[1]))

        self.shapes = '02.45/1010/22._33/_33.22/464._4/5.5.52/_6._6.56'.split('/')
        self.shape_colors = [colors.red,colors.orange,colors.lime,colors.lblue,colors.yellow,colors.blue,colors.lpurple]

        self.resetgame()
        self.movespeed = 8
        self.movedelay = 0
        
        if random.randint(0,1): pygame.mixer.music.load('tetrisb.mid')
        else: pygame.mixer.music.load('tetrisc.mid')
        pygame.mixer.music.play(-1, 0.0)

    def resetgame(self):
        self.tiles, self.colors = [], []
        self.pos, self.orient = [self.gs[0]//2,0], 0
        self.game_over, self.score, self.lines, self.frame = False, 0, 0, 0
        self.current, self.next = random.randrange(len(self.shapes)), [random.randrange(len(self.shapes)) for i in range(4)]

    def convert(self,s,o,pos=(0,0)):
        s = s.split('.')
        h,w = len(s)-1,len(max(s))-1
        return [(pos[0]+([x,h-y,w-x,y][o])-1,pos[1]+([y,x,h-y,w-x][o])-h-1) for y in range(len(s)) for x in range(len(s[y])) if s[y][x]!='_']

    def get_colors(self,current,i=None):
        body = self.convert(self.shapes[current],0)
        x,y = min(body,key=lambda i:i[0])[0], min(body,key=lambda i:i[1])[1]
        if i!=None: return int(self.shapes[current].split('.')[body[i][1]-y][body[i][0]-x])
        else: return [int(self.shapes[current].split('.')[row-y][col-x]) for col,row in body]

    def run(self, up, down, left, right):
        self.active = 0
        if key.state("UP"): self.rect.y-=self.speed
        if key.state("DOWN"): self.rect.y+=self.speed
        if key.state("LEFT"): self.rect.x-=self.speed
        if key.state("RIGHT"): self.rect.x+=self.speed

        [pygame.mixer.music.set_volume(1/i if i else 0) for i in range(10) if key.state(str(i))]

        if not self.game_over:
            self.fallspeed = 12 if key.state(down) else 3

            self.body = self.convert(self.shapes[self.current],self.orient,self.pos)

            if key.down("SPACE"):
                while not any([(i[0],i[1]+1) in self.tiles or i[1]>self.gs[1]-2 for i in self.body]):
                    self.pos[1]+=1
                    self.body = self.convert(self.shapes[self.current],self.orient,self.pos)

            left_key = key.state(left) and all([(i[0]-1,i[1]) not in self.tiles and i[0]>0 and i[0]<self.gs[0] for i in self.body])
            right_key = key.state(right) and all([(i[0]+1,i[1]) not in self.tiles and i[0]>-2 and i[0]<self.gs[0]-1 for i in self.body])

            if self.movedelay: self.movedelay-=1
            if left_key ^ right_key:
                l,r = key.down(left), key.down(right)
                if l or r: self.movedelay = main.fps//3
                self.pos[0] = self.pos[0] + (-1 if l else 1 if r else 0)
                if not (self.frame%(main.fps//self.movespeed) or self.movedelay): self.pos[0] = self.pos[0] + (-1 if left_key else 1 if right_key else 0)
                self.body = self.convert(self.shapes[self.current],self.orient,self.pos)

            rotated_tiles = self.convert(self.shapes[self.current],(self.orient+1)%4,self.pos)
            rotate_valid = all([i not in self.tiles and i[0]>=0 and i[0]<self.gs[0] and i[1]<self.gs[1] for i in rotated_tiles])
            if key.down(up) and rotate_valid: self.orient, self.body = (self.orient+1)%4, self.convert(self.shapes[self.current],(self.orient+1)%4,self.pos)

            if self.frame%(main.fps//self.fallspeed)==0:
                if any([(i[0],i[1]+1) in self.tiles or i[1]>self.gs[1]-2 for i in self.body]):
                    if all([i>=0 for tile in self.body for i in tile]):
                        self.score+=25
                        self.tiles+=self.body
                        self.colors+=self.get_colors(self.current)
                            
                        self.pos, self.orient, self.current, self.next = [self.gs[0]//2,0], 0, self.next[0], self.next[1:]+[random.randrange(len(self.shapes))]
                        lines = [y for y in range(self.gs[1]) if len([0 for x in range(self.gs[0]) if (x,y) in self.tiles])==self.gs[0]]
                        self.lines, self.score = self.lines+len(lines), self.score+len(lines)*150

                        for y in lines:
                            for x in range(self.gs[0]): del self.colors[self.tiles.index((x,y))]; del self.tiles[self.tiles.index((x,y))]
                            self.tiles = [(i[0],i[1]+1) if i[1]<y else i for i in self.tiles]

                    else: self.game_over = True
                else: self.pos[1]+=1

            self.frame = (self.frame+1)%main.fps

        if key.state("BACKSPACE"): self.resetgame()

    def draw_background(self,rect,color1,color2,color3):
        pygame.draw.rect(main.screen, color1, (rect.x-6,rect.y-6,rect.width+12,rect.height+12))
        for i in range(0,rect.width+10,10): pygame.draw.line(main.screen, color2, (rect.left+i,rect.top),(rect.left+(i-rect.height if i>rect.height else 0),rect.top+i if i<rect.height else rect.bottom),4)
        for i in range(-1,rect.height,10): pygame.draw.line(main.screen, color2, (rect.right,rect.bottom-i),(rect.right-i if i<rect.width else rect.left,rect.bottom-(i-rect.width if i>rect.width else 0)),4)
        pygame.draw.rect(main.screen, color3, (rect.x-6,rect.y-6,rect.width+12,rect.height+12), 6)

    def draw_tile(self,tile,color,pos=None):
        if not pos: pos = self.rect.topleft
        x,y,w,h = pygame.Rect((pos[0]+tile[0]*(self.ps[0]+self.ms[0])+self.ms[0], pos[1]+tile[1]*(self.ps[1]+self.ms[1])+self.ms[1]), self.ps)
        pygame.draw.rect(main.screen, colors.black, (x-self.ms[0],y-self.ms[1],w+self.ms[0]*2,h+self.ms[1]*2))
        pygame.draw.rect(main.screen, color, (x,y,w,h))

    def restart_button(self):
        text = fonts.beast(25).render("Restart", True, colors.black)
        (x,y),(w,h) = center((self.rect.centerx,self.rect.centery+100),text.get_size()),text.get_size()
        rect = pygame.Rect(x-4,y-4,w+8,h+8)
        collide = rect.collidepoint(mouse.pos())
        pygame.draw.rect(main.screen, colors.black, rect)
        pygame.draw.rect(main.screen, colors.lime if collide and self.active else colors.yellow, (x,y,w,h))
        main.screen.blit(text,(x,y))

        if self.active and (key.down("RETURN") or (collide and mouse.up(1))): self.resetgame()

    def draw(self):
        self.active = True if type(self.active)==int else False
        
        self.draw_background(self.rect,colors.llblue,colors.lllblue,colors.black)
        [self.draw_tile(i,self.shape_colors[self.get_colors(self.current,self.body.index(i))]) for i in self.body if i[0]>=0 and i[0]<self.gs[0] and i[1]>=0 and i[1]<self.gs[1]]
        [self.draw_tile(self.tiles[i],self.shape_colors[self.colors[i]]) for i in range(len(self.tiles))]

        for z in range(len(self.next)):
            tiles = self.convert(self.shapes[self.next[z]],0)
            [self.draw_tile(tiles[i],self.shape_colors[self.get_colors(self.next[z],i)],(self.rect.right+50,self.rect.y+120+(z*100))) for i in range(len(tiles))]

        text = fonts.beast(16).render("Lines: "+str(self.lines), True, colors.aqua, colors.black)
        main.screen.blit(text,(self.rect.x-150,170+self.rect.y))

        texta = fonts.beast(16).render("Score:", True, colors.aqua, colors.black)
        main.screen.blit(texta,(self.rect.x-150,220+self.rect.y))

        textb = fonts.beast(16).render(str(self.score), True, colors.aqua, colors.black)
        main.screen.blit(textb,(self.rect.x-150+texta.get_width()//2-textb.get_width()//2,260+self.rect.y))

        if self.game_over:
            text = fonts.beast(40).render("Game Over", True, colors.aqua, colors.black)
            main.screen.blit(text,center((self.rect.centerx,self.rect.centery-100),text.get_size()))

            text = fonts.beast(25).render("Your Score", True, colors.aqua, colors.black)
            main.screen.blit(text,center((self.rect.centerx,self.rect.centery-40),text.get_size()))

            text = fonts.beast(25).render(str(self.score), True, colors.aqua, colors.black)
            main.screen.blit(text,center((self.rect.centerx,self.rect.centery+10),text.get_size()))

            self.restart_button()


main = setup((600,600),"Tetris",60)

tetris = grid((10,20),(24,24),(4,4),10)
tetris.rect.center = main.screen.get_rect().center

while True:
    main.events()
    if not main.paused: tetris.run("w","s","a","d")
    tetris.draw()
