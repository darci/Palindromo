package oi.github.darci.palindromo.view.palindrome.list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import oi.github.darci.palindromo.R;
import oi.github.darci.palindromo.data.model.Palindrome;

import java.util.List;

public class PalindromeAdapter extends RecyclerView.Adapter<PalindromeViewHolder>
        implements ListPalindromeContract.View {

    private List<Palindrome> palindromes;
    private ListPalindromeContract.Presenter presenter;
    private ListPalindromeContract.View aboveViewContract;

    public PalindromeAdapter(ListPalindromeContract.View aboveViewContract, ListPalindromeContract.Presenter presenter) {
        this.aboveViewContract = aboveViewContract;
        this.presenter = presenter;
        presenter.attach(this);
        presenter.list();
    }

    @Override
    public PalindromeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PalindromeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_palindrome_list, parent, false));
    }

    @Override
    public void onBindViewHolder(PalindromeViewHolder holder, int position) {
        holder.title.setText(palindromes.get(position).getText());

        holder.deleteButton.setOnClickListener(view -> removerItem(palindromes.get(position)));
    }

    private void removerItem(Palindrome palindrome) {
        presenter.delete(palindrome);
    }

    @Override
    public int getItemCount() {
        return palindromes != null ? palindromes.size() : 0;
    }

    @Override
    public void update(List<Palindrome> palindromes) {
        aboveViewContract.update(palindromes);
        this.palindromes = palindromes;
        notifyDataSetChanged();
    }

    @Override
    public void setPresenter(ListPalindromeContract.Presenter presenter) {
        aboveViewContract.setPresenter(presenter);
        this.presenter = presenter;
    }
}