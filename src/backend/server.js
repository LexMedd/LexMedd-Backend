const express = require('express');
const app = express();
const port = 3000;

const doctors = [
  {
    name: 'Dr. Juan Pérez',
    specialty: 'cardiology',
    location: 'lima',
    description: 'Cardiólogo...',
    image: 'assets/image/doctor1.jpg'
  },
  {
    name: 'Dra. Laura Gómez',
    specialty: 'neurology',
    location: 'cusco',
    description: 'Neurologa...',
    image: 'assets/image/doctor.jpg'
  },
  {
    name: 'Dr. Alberto Díaz',
    specialty: 'pediatrics',
    location: 'arequipa',
    description: 'Pediatra...',
    image: 'assets/image/doctor3.jpg'
  },
  {
    name: 'Dra. Mariana Fernández',
    specialty: 'dermatology',
    location: 'lima',
    description: 'Dermatóloga...',
    image: 'assets/image/doctor2.jpg'
  }
];

app.get('/api/doctors', (req, res) => {
  res.json(doctors);  // Devuelve la lista de doctores en formato JSON
});

app.listen(port, () => {
  console.log(`Backend running at http://localhost:${port}`);
});
