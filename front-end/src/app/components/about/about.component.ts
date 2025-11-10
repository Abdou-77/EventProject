import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

interface ValueCard {
  title: string;
  description: string;
}

interface TeamMember {
  name: string;
  role: string;
  bio: string;
  imageUrl: string;
}

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent {
  readonly introHighlight = 'Événements pensés comme des expériences totales';

  values: ValueCard[] = [
    {
      title: 'Curation exigeante',
      description: 'Chaque événement est sélectionné pour son impact émotionnel, son esthétique et sa capacité à offrir un moment rare.'
    },
    {
      title: 'Design premium',
      description: 'Une expérience digitale pensée comme un écrin : interfaces éthérées, visuels immersifs, parcours sans friction.'
    },
    {
      title: 'Human first',
      description: 'Nous croyons aux rencontres. Notre équipe accompagne organisateurs et communautés pour créer du lien.'
    }
  ];

  team: TeamMember[] = [
    {
      name: 'Ava Morin',
      role: 'Directrice Créative',
      bio: 'Architecte d’expériences, Ava imagine l’univers visuel d’EventApp et sculpte chaque interaction.',
      imageUrl: 'https://images.unsplash.com/photo-1544723795-3fb6469f5b39?auto=format&fit=crop&w=600&q=80'
    },
    {
      name: 'Léo Bernard',
      role: 'Head of Partnerships',
      bio: 'Il cultive un réseau de partenaires culturels et repère les événements qui méritent d’être révélés.',
      imageUrl: 'https://images.unsplash.com/photo-1544005313-94ddf0286df2?auto=format&fit=crop&w=600&q=80'
    },
    {
      name: 'Maya Khelifi',
      role: 'Product Lead',
      bio: 'Obsédée par le détail, elle pilote la feuille de route produit et garantit la fluidité de la plateforme.',
      imageUrl: 'https://images.unsplash.com/photo-1504593811423-6dd665756598?auto=format&fit=crop&w=600&q=80'
    }
  ];

  stats = [
    { label: 'Événements accompagnés', value: '120+' },
    { label: 'Partenaires culturels', value: '45' },
    { label: 'Taux de satisfaction', value: '4.9 / 5' }
  ];
}
