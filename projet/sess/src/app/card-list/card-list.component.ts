// card-list.component.ts

import { Component, OnInit } from '@angular/core';
import { PokerCardService } from '../services/poker-card.service';

@Component({
  selector: 'app-card-list',
  templateUrl: './card-list.component.html',
  styleUrls: ['./card-list.component.css']
})
export class CardListComponent implements OnInit {
  pokerCards: any[] = [];
  selectedCard: any = { id: null, name: '', complexityValue: 0 };
  showForm: boolean = false;

  constructor(private pokerCardService: PokerCardService) { }

  ngOnInit(): void {
    this.loadPokerCards();
  }

  loadPokerCards(): void {
    this.pokerCardService.getAllCards().subscribe(cards => this.pokerCards = cards);
  }

  addCard(): void {
    this.pokerCardService.addCard(this.selectedCard).subscribe(() => {
      this.selectedCard = { id: null, name: '', complexityValue: 0 };
      this.loadPokerCards();
      this.showForm = false;
    });
  }

  deleteCard(card: any): void {
    // Vérifiez si une carte est sélectionnée
    if (card && card.id) {
      this.pokerCardService.deleteCard(card.id).subscribe(() => {
        this.loadPokerCards();
        this.selectedCard = { id: null, name: '', complexityValue: 0 };
      });
    } else {
      console.error('Aucune carte sélectionnée pour la suppression.');
    }
  }

  selectCard(card: any): void {
    this.selectedCard = { ...card };
    this.showForm = true;
  }

  showAddForm(): void {
    this.selectedCard = { id: null, name: '', complexityValue: 0 };
    this.showForm = true;
  }
}

