const EventEmitter = require('events');

// Create an emitter
const emitter = new EventEmitter();

// Register an event
emitter.on('greet', (name) => {
  console.log(`Hello, ${name}!`);
});

// Emit the event
emitter.emit('greet', 'Prakash');
