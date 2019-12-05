[
 {
    '0x1': {
        'type': 'place',
        'NAME': 'room',
        'DESCRIPTION': '',
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
                     'cave':{
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
        'NAME': 'cave',
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
