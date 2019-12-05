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
        'DESCRIPTION': '',
        'characters': {
                       },
        'exits': {
                     'trail':{
                           'type': 'exit',
                           'NAME': '',
                           'DESCRIPTION': ''
                     },
                     'cave':{
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
     '0x7': {
        'type': 'place',
        'NAME': 'cave',
        'DESCRIPTION': '',
        'characters': {
                       },
        'exits': {
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
     '0x8': {
        'type': 'place',
        'NAME': 'moutain',
        'DESCRIPTION': '',
        'characters': {
                       },
        'exits': {
                     'trail':{
                           'type': 'exit',
                           'NAME': '',
                           'DESCRIPTION': ''
                     },
                     'stream':{
                           'type': 'fog',
                           'NAME': '',
                           'DESCRIPTION': '',
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
        'DESCRIPTION': '',
        'characters': {
                       },
        'exits': {
                     'moutain':{
                           'type': 'exit',
                           'NAME': '',
                           'DESCRIPTION': ''
                     },
                     'boat':{
                           'type': 'waterfall',
                           'NAME': '',
                           'DESCRIPTION': '',
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
        'DESCRIPTION': '',
        'characters': {
                       },
        'exits': {

                   },
        'items': {
                    }
     }
 }
]
