var app = angular.module('NotesApp', ['ngRoute','ngAnimate','ngResource']);

app.config(function ($routeProvider) {
  $routeProvider
    .when('/note', {
      controller: 'NotesHomeController',
      templateUrl: 'views/notesHome.html'
    })	
	.when('/addNewNote', {
      controller: 'AddNewNoteController',
      templateUrl: 'views/addNote.html'
    })
    .otherwise({
      redirectTo: '/note'
    });
});
