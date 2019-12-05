[
 {
    '0x1': {
        'type': 'place',
        'NAME': 'room',
        'DESCRIPTION': '\n This is the room that you rented in a little inn.\n All your personnal stuff were stealed while you were sleeping, including the talisman meant to protect your native town.\n You decide to search for it and take it back !\n There is a chest and a door.',
        'characters': {
                        'player': {
                               'type': 'hero',
                               'NAME': 'player',
                               'life': 30,
                               'currentWeapon': {
                                   'type': 'sword',
                                   'NAME': 'sword',
                                   'Description': 'Your fidel sword that foloow you everywhere',
                                   'damage': 4
                               },
                               'currentPlace': '0x1'
                         }
                       },
        'exits': {
                     'corridor': {
                           'type': 'wooden door',
                           'NAME': 'door',
                           'DESCRIPTION': 'A wooden door which leads to the corridor in the inn'
                     }
                  },
        'items': {
                    'chest': {
                          'type': 'chest',
                          'NAME': 'chest',
                          'DESCRIPTION': 'A locked chest, did they have stolen the key of this chest too ?!',
                          'locked': true,
                          'containedItem': {
                               'type': 'bread',
                               'NAME': 'bread',
                               'DESCRIPTION': 'A bread which restore 10 HP',
                               'nbEffect': 10
                         },
                          'place': '0x1'
                    }
                  }
  }
 },
 {
     '0x2': {
        'type': 'place',
        'NAME': 'corridor',
        'DESCRIPTION': 'This is the corridor of the inn.\n There is no trace of people here.\n There is a wooden door, a lock door and a passage to the reception.',
        'characters': {
                        
                       },
        'exits': {
                     'room':{
                           'type': 'wooden door',
                           'NAME': 'wooden door',
                           'DESCRIPTION': 'A wooden door which leads to your room.'
                     },
                     'cellar':{
                           'type': 'locked exit',
                           'NAME': 'lock door',
                           'DESCRIPTION': 'It leads to the cellar.',
                           'locked': true
                     },
                     'reception':{
                           'type': 'wooden door',
                           'NAME': 'passage',
                           'DESCRIPTION': 'Leads to the reception.'
                     }
                  },
        'items': {
                     'beam': {
                          'type': 'beam traped',
                          'NAME': 'beam',
                          'DESCRIPTION': 'You approach of the beam, a little to close, you \nbump your head on it and lose 3 HP',
                          'locked': true,
                          'DAMAGE': 3,
                          'containedItem': {             
                               'type': 'door key',
                               'NAME': 'pass',
                               'DESCRIPTION': 'Pass that can unlock a door.'
                           },
                          'place': '0x2'
                    } 
                 }
     }
 },
 {
     '0x3': {
        'type': 'place',
        'NAME': 'cellar',
        'DESCRIPTION': 'The cellar, there is a bottle of wine and the door by which you entered.',
        'characters': {
                       },
        'exits': {
                     'corridor':{
                           'type': 'exit',
                           'NAME': 'door',
                           'DESCRIPTION': 'The door that leads to the corridor.'
                     }
                  },
        'items': {
                 'wine': {
                        'type': 'wine',
                        'NAME': 'wine',
                        'DESCRIPTION': 'A bottle of wine that restore 8 HP',
                        'nbEffect': 8

                 }
        }
     }
 },
 {
     '0x4': {
        'type': 'place',
        'NAME': 'reception',
        'DESCRIPTION': 'The reception of the inn.\n The manager look at you nonchalantly and put a key on the counter.\n There is a beam, a passage that leads to the corridor and a door which leads to the trail out of the inn.. ',
        'characters': {
                       },
        'exits': {
                     'corridor':{
                           'type': 'exit',
                           'NAME': 'passage',
                           'DESCRIPTION': ''
                     },
                     'trail':{
                           'type': 'exit',
                           'NAME': 'door',
                           'DESCRIPTION': ''
                     }
                  },
        'items': {
                'beam': {
                          'type': 'beam classic',
                          'NAME': 'beam',
                          'DESCRIPTION': 'You approach of the beam and discover that a pass is hidden here.',
                          'locked': true,
                          'containedItem': {             
                               'type': 'door key',
                               'NAME': 'pass',
                               'DESCRIPTION': 'Pass that can unlock a door.'
                           },
                          'place': '0x4'

                },
                'key': {             
                        'type': 'chest key',
                        'NAME': 'key',
                        'DESCRIPTION': 'Key that can unlock something.'
                }    
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
