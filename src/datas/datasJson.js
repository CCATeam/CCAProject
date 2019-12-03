[
 {
    '0x1': {
        'NAME': 'chambre',
        'DESCRIPTION': 'premiere place, il y a un chest,une chestkey, une woodendoor et orc1',
        'CHARACTERS': {
                         'Me': {
                               'type': 'hero',
                               'NAME': 'Me',
                               'life': 100,
                               'currentWeapon': {
                                    'type': 'axe'
                                },
                               'currentPlace': '0x1'
                         },
                          'orc1': {
                               'type': 'orc',
                               'NAME': 'orc1',
                               'currentPlace': '0x1'
                         }
                       },
        'EXITS': {
                     'couloir': {
                           'type': 'wooden door',
                           'NAME': 'woodendoor',
                           'DESCRIPTION': 'Porte en bois qui mène vers la salle test2'
                     }
                  },
        'ITEMS': {
                         'chestkey': {             
                               'type': 'chest key',
                               'NAME': 'chestkey',
                               'DESCRIPTION': 'Chest Key'
                         },
                         'chest': {
                               'type': 'chest',
                               'NAME': 'chest',
                               'DESCRIPTION': 'blablabla2',
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
        'CHARACTERS': {
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
        'EXITS': {
                     'chambre':{
                           'type': 'exit',
                           'NAME': 'exittest',
                           'DESCRIPTION': 'testExit'
                     },
                     'sortie':{
                           'type': 'locked exit',
                           'NAME': 'closeddoor',
                           'DESCRIPTION': 'testExit',
                           'locked': true
                     }
                  },
        'ITEMS': {
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
        'CHARACTERS': {
                       },
        'EXITS': {

                   },
        'ITEMS': {
                    }
     }
 }
 ]