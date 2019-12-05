[
 {
    '0x1': {
        'type': 'place',
        'NAME': 'room',
        'DESCRIPTION': '\n This is the room that you rented in a little inn.\n All your personnal stuff was stealed while you were sleeping,including the talisman meant to protect your native town.\n You decide to search for it and take it bag !',
        'characters': {
                        'player': {
                               'type': 'hero',
                               'NAME': 'player',
                               'life': 30,
                               'currentWeapon': {
                                   'type': 'sword',
                                   'NAME': 'sword',
                                   'Description': 'a sword',
                                   'damage': 4
                               },
                               'currentPlace': '0x1'
                         }
                       },
        'exits': {
                     'corridor': {
                           'type': 'wooden door',
                           'NAME': '',
                           'DESCRIPTION': ''
                     }
                  },
        'items': {
                    
                  }
  }
 },
 {
     '0x2': {
        'type': 'place',
        'NAME': 'corridor',
        'DESCRIPTION': '',
        'characters': {
                        
                       },
        'exits': {
                     'room':{
                           'type': 'wooden door',
                           'NAME': '',
                           'DESCRIPTION': ''
                     },
                     'cellar':{
                           'type': 'locked exit',
                           'NAME': '',
                           'DESCRIPTION': '',
                           'locked': true
                     },
                     'reception':{
                           'type': 'wooden door',
                           'NAME': '',
                           'DESCRIPTION': ''
                     }
                  },
        'items': {
                     
                 }
     }
 },
 {
     '0x3': {
        'type': 'place',
        'NAME': 'cellar',
        'DESCRIPTION': 'Congratulation, you finished the game ! You can quit now.',
        'characters': {
                       },
        'exits': {
                     'corridor':{
                           'type': 'wooden door',
                           'NAME': '',
                           'DESCRIPTION': ''
                     }
                  },
        'items': {
                    }
     }
 },
 {
     '0x4': {
        'type': 'place',
        'NAME': 'reception',
        'DESCRIPTION': '',
        'characters': {
                       },
        'exits': {
                     'corridor':{
                           'type': 'exit',
                           'NAME': '',
                           'DESCRIPTION': ''
                     },
                     'trail':{
                           'type': 'exit',
                           'NAME': '',
                           'DESCRIPTION': ''
                     }
                  },
        'items': {
                    }
     }
 },
 {
     '0x5': {
        'type': 'place',
        'NAME': 'trail',
        'DESCRIPTION': '',
        'characters': {
                       },
        'exits': {
                     'moutain':{
                           'type': 'exit',
                           'NAME': '',
                           'DESCRIPTION': ''
                     },
                     'forest':{
                           'type': 'exit',
                           'NAME': '',
                           'DESCRIPTION': ''
                     }
                 },
        'items': {
                    }
     }
 },
 {
     '0x6': {
        'type': 'place',
        'NAME': 'forest',
        'DESCRIPTION': 'You enter a dark forest. The sunlight hardly gets through the foliage. You still notice a trail and the entrance of a cave.',
        'characters': {
                       },
        'exits': {
                     'trail':{
                           'type': 'exit',
                           'NAME': 'trail',
                           'DESCRIPTION': 'A dark trail that seems to take the direction of the mountains.'
                     },
                     'cave':{
                           'type': 'exit',
                           'NAME': 'cave',
                           'DESCRIPTION': 'There is a feeble light coming from inside this cave, and you would swear that you just heard a disgusting growl coming from there...'
                     }
                 },
        'items': {
                    }
     }
 },
 {
     '0x7': {
        'type': 'place',
        'NAME': 'cave',
        'DESCRIPTION': 'You gather your courage and penetrate the cave. The stench of blood and rotting flesh fills your lumgs and you repress the urge to throw up.\nA bit farther into the cave, you discover where the light was coming from. A vaguely humanoid creature is eating something, sitting on the ground, enlightened by a lantern.\n As you approach here discretely, you notice it\'s dark green skin and it\' porcine face munching greedily on a piece of raw meet. And the stench, oh god that stench...',
        'characters': {
                        'orc':{
                            'type': 'orc',
                            'NAME': 'cave orc',
                            'currentPlace' : '0x7',
                            'loot':{
                                'type':'door key',
                                'NAME':'lantern',
                                'DESCRIPTION':'An old lantern with a flickering flame. It could still prove to be usefull though.'
                            }
                        }
                       },
        'exits': {
                     'forest':{
                           'type': 'exit',
                           'NAME': 'forest',
                           'DESCRIPTION': 'There might be another exit from this cave, but you\'re certainly not foolish enough to try and find yourself into a labyrinth of gallery in which no light ever comes.\nThe only possible option is to go back to the forest you came from.'
                     }
                 },
        'items': {
                    }
     }
 },
 {
     '0x8': {
        'type': 'place',
        'NAME': 'moutain',
        'DESCRIPTION': 'After walking for what seems to be hours, you notice that the trees are letting place to the red light of the sunset. You are in the moutains and the fresh wind of this cold evening feels revigorating. The trail seems to lead further into the mountains, but a cloud of fog makes it dangerous to keep walking it.',
        'characters': {
                       },
        'exits': {
                     'trail':{
                           'type': 'exit',
                           'NAME': 'forest',
                           'DESCRIPTION': 'You can still go back to the forest and try you luck in the caves.'
                     },
                     'stream':{
                           'type': 'fog',
                           'NAME': 'waterfall',
                           'DESCRIPTION': 'From this fog can be heard the song of water smashing against rock. Sounds like a waterfall. \nIt would definitely be crazy to keep going without something to help you see where you put your feet.',
                           'locked': true
                     }
                 },
        'items': {
                    }
     }
 },
 {
     '0x9': {
        'type': 'place',
        'NAME': 'stream',
        'DESCRIPTION': 'Now trembling in the cold worsened by the thousands of tiny drops of water suspended in the air around you, you keep walking focused on where you put your feet at the light of your lantern.\n Somehow, you manage not to fall or slip in the precipice bordering your path.\n The kind warmth of your light is not enough to suppress your thoughts of the Inn you left what seems to be days ago and it\'s agressive beams, but it\'s still conforting.\n The fog finally disappears and you arrive to a waterfall. It\'s a wonderful sight, the water looks like liquid silver under the moonlight and it would be a worthy reward for all those hardships you got through if it wasn\'t for this monstruous duck coming in you direction, weaving an umbrella with the firm intention of ending your life.',  
        'characters': {
                        'lord duck':{
                            'type': 'lord duck',
                            'NAME': 'lord duck',
                            'currentPlace' : '0x9',
                            'loot':{
                                'type':'door key',
                                'NAME':'umbrella',
                                'DESCRIPTION':'A big umbrella for a big duck.'
                            }
                        }
            
                       },
        'exits': {
                     'moutain':{
                           'type': 'exit',
                           'NAME': 'mountain',
                           'DESCRIPTION': 'You may go back to the mountains through the fog if you\'re not affraid to fall.'
                     },
                     'boat':{
                           'type': 'waterfall',
                           'NAME': 'boat',
                           'DESCRIPTION': 'There seems to be boat hidden behind this waterfall, but you will need something to protect yourself to get through.',
                           'locked': true
                     }
                 },
        'items': {
                    }
     }
 },
 {
     '0x10': {
        'type': 'final place',
        'NAME': 'boat',
        'DESCRIPTION': 'You found a boat, you are now free to go wherever you want in this fantastic world. Maybe you should look around to find what it\'s precedent owners left.\nDo not worry for them though, they won\'t need it after the funest fate they met at the palms of lord duck.\n Look right there, maybe you could start with that beam ?',
        'characters': {
                       },
        'exits': {

                   },
        'items': {
                'chest':{
                    'type':'chest',
                    'NAME':'beam',
                    'DESCRIPTION':'That\'s a big beam for sure. Maybe you should take a look behind it !',
                    'locked': false,
                    'currenPlace':'0x10'
                }
            }
     }
 }
]
