[
 {
    '0x1': {
        'NAME': 'chambre',
        'DESCRIPTION': 'premiere place, il y a un chest,une clef, une porte ouverte et un orc1',
        'characters': {
                         'Me': {
                               'type': 'hero',
                               'NAME': 'Me',
                               'life': 100,
                               'currentPlace': '0x1'
                         },
                          'orc1': {
                               'type': 'orc',
                               'NAME': 'orc1',
                               'currentPlace': '0x1',
                               'loot': {            
                                    'type': 'chest key',
                                    'NAME': 'clef',
                                    'DESCRIPTION': 'A première vue la clef d\'un coffre'                                
                               }
                         }
                       },
        'exits': {
                     'couloir': {
                           'type': 'wooden door',
                           'NAME': 'woodendoor',
                           'DESCRIPTION': 'porte en bois qui mène vers un couloir.'
                     }
                  },
        'items': {
                         'chest': {
                               'type': 'chest',
                               'NAME': 'chest',
                               'DESCRIPTION': 'un coffre au trésor',
                               'locked': true,
                               'containedItem': {             
                                    'type': 'door key',
                                    'NAME': 'doorkey',
                                    'DESCRIPTION': 'Key of a door'
                                },
                               'place': '0x1'

                         }
                  }
  }
 },
 {
     '0x2': {
        'NAME': 'couloir',
        'DESCRIPTION': 'deuxieme place',
        'characters': {
                          'orc2': {
                               'type': 'orc',
                               'NAME': 'orc2',
                               'currentPlace': '0x2'
                         },
                          'orc3': {
                               'type': 'orc',
                               'NAME': 'orc3',
                               'currentPlace': '0x2'
                         }
                       },
        'exits': {
                     'chambre':{
                           'type': 'exit',
                           'NAME': 'exittest',
                           'DESCRIPTION': 'testExit'
                     },
                     'sortie':{
                           'type': 'locked exit',
                           'NAME': 'porte',
                           'DESCRIPTION': 'Porte de sortie test fermee',
                           'locked': true
                     }
                  },
        'items': {
                         'item3': {
                               'type': 'item',
                               'NAME': 'item3',
                               'DESCRIPTION': 'blabla3'
                         },
                         'item4': {
                               'type': 'item',
                               'NAME': 'item4',
                               'DESCRIPTION': 'blabla4'
                         }
                       }
     }
 },
 {
     '0x3': {
        'NAME': 'sortie',
        'DESCRIPTION': 'Congratulation, you finished the game ! You can quit now.',
        'characters': {
                       },
        'exits': {

                   },
        'items': {
                    }
     }
 }
]