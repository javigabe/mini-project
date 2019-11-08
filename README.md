# **Mini-Project**

## **Contenido del directorio raiz**
- src -> En esta carpeta esta el codigo fuente de la practica y los tests
- pom.xml -> archivo con la configuracion del proyecto
- README.md -> fichero con la descripcion del proyecto
- .gitignore -> fichero con los archivos a ser ignorados por el repositorio

## **Instrucciones**

Para ejecutar todos los test hay que tener instalada la herramienta Maven y ejecutar el comando "mvn test".
y algo

## **Contenido src/main**
- UniversityManager: implementa la interfaz UniversityManagerInterface. En este fichero se implementa toda la
  funcionalidad del proyecto con los metodos abajo descritos.

  registerStudent: Registers a student in the system and checks if the student is not null."\n"
  addStudentToCourse: Registers a student in a course and checks if the student and the course are already in the system and if the course is full.
  removeStudentFromCourse: Removes a student from a course and checks if the student and the course are already in the system and if the student is enrolled in that course.

registerStudent: Registers a student in the system and checks if student is not null.
addStudentToCourse: Registers a student in a course and checks if the student and the course are already in the system and if the course is full.
removeStudentFromCourse: Removes a student from a course and checks if the student and the course are already in the system and if the student is enrolled in that course.
registerCourse: Registers a course in the system and checks if the course is not null.
matriculatedStudent: Returns all the students in a course sorted by the ID, it checks if the course is registered.
cancelCourse: Empty the course if it exists.
allUsersSorted: Returns all the registered students sorted by ID.
allCoursesSorted: Returns all the registered courses sorted by ID.


- Student -> Implementa la clase Student utilizada en el UniversityManager.
- Course -> Implementa la clase Course utilizada en el UniversityManager.
- Excepciones -> Se implementan las excepciones concretas para el proyecto.

## **Contenido src/test**
- AppTest -> En este fichero se han implementado todos los test para el proyecto
