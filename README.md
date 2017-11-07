# AndroidPermissionsBehaviour
its a simple app to test androids behaviour towards individual permission as well as the permission group.
it actually verifies what android told in documentation.
Main points:
          -dangerous permissions are asked at the run time.
          -the developer will write code to asks the users for a dangerous permission.
          -if the user allows a dangerous permission "A" ,after that if app asks for another permission from the permission group 
          the permission "A" belongs to then android will allow it automatically without asking user . 
          -if a user allowed any one permission from any permission group ,then in order to use the rest of the permissions 
          from that group the app still needs to be request and they will be allowed by system and not the user .
          if app asks for any particular permission "A",user will be shown a dialog with only name of the permission group the permission 
          "A" belongs to and not the specific permission.
        
          
